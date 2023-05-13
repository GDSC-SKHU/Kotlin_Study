package com.example.post.post.api

import com.example.post.post.app.PostService
import com.example.post.post.dto.request.PostWrite
import com.example.post.post.dto.response.PostResponse
import com.example.post.post.dto.response.PostDetailsResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.IllegalStateException

@RestController
@RequestMapping("/api/post")
class PostController(private val postService: PostService) {

    // 전체 게시글 목록 조회
    @GetMapping("list")
    fun findAllPost(): ResponseEntity<List<PostResponse>> {
        return ResponseEntity(postService.findAll(), HttpStatus.OK)
    }

    // id가 일치하는 게시글 조회
    @GetMapping("{id}")
    fun findPost(@PathVariable("id") id: Long): ResponseEntity<*> {
        return try {
            ResponseEntity(postService.findById(id), HttpStatus.OK)
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    // 새로운 게시글 작성
    @PostMapping("")
    fun writePost(@RequestBody request: PostWrite): ResponseEntity<PostDetailsResponse> {
        return ResponseEntity<PostDetailsResponse>(postService.write(request), HttpStatus.OK)
    }

    // id가 일치하는 게시글 수정
    @PutMapping("{id}")
    fun editPost(@PathVariable("id") id: Long, @RequestBody request: PostWrite): ResponseEntity<*> {
        return try {
            ResponseEntity(postService.edit(id, request), HttpStatus.OK)
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    // id가 일치하는 게시글 삭제
    @DeleteMapping("{id}")
    fun deletePost(@PathVariable("id") id: Long): ResponseEntity<String> {
        return try {
            ResponseEntity<String>(postService.delete(id), HttpStatus.OK)
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

}