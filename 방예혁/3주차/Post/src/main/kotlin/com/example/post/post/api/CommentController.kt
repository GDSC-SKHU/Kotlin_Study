package com.example.post.post.api

import com.example.post.post.app.CommentService
import com.example.post.post.dto.request.CommentWrite
import com.example.post.post.dto.response.CommentResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.IllegalStateException

@RestController
@RequestMapping("/api/comment")
class CommentController(private val commentService: CommentService) {

    // 새로운 댓글 작성
    @PostMapping("")
    fun writeComment(@RequestBody request: CommentWrite): ResponseEntity<CommentResponse> {
        return ResponseEntity<CommentResponse>(commentService.write(request), HttpStatus.OK)
    }

    // id가 일치하는 댓글 수정
    @PutMapping("{commentId}")
    fun editPost(@PathVariable("commentId") commentId: Long, @RequestBody request: CommentWrite): ResponseEntity<*> {
        return try {
            ResponseEntity(commentService.edit(commentId, request), HttpStatus.OK)
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    // id가 일치하는 댓글 삭제
    @DeleteMapping("{commentId}")
    fun deletePost(@PathVariable("commentId") commentId: Long): ResponseEntity<String> {
        return try {
            ResponseEntity<String>(commentService.delete(commentId), HttpStatus.OK)
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

}