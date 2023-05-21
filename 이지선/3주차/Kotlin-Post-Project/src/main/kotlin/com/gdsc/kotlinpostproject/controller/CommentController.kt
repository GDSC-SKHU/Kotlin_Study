package com.gdsc.kotlinpostproject.controller

import com.gdsc.kotlinpostproject.domain.model.Comment
import com.gdsc.kotlinpostproject.service.CommentService
import com.gdsc.kotlinpostproject.service.PostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/posts")
@RestController
class CommentController (
    private val commentService: CommentService,
    private val postService: PostService
        ){
    @PostMapping("/{postId}/comments")
    fun createPost(@PathVariable postId: Long, @RequestBody comment: Comment) : ResponseEntity<Comment> {
        return ResponseEntity.ok(commentService.create(postService.findById(postId), comment))
    }

    @DeleteMapping("/comments/{commentId}")
    fun delete(@PathVariable commentId: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok(commentService.delete(commentId))
    }
}