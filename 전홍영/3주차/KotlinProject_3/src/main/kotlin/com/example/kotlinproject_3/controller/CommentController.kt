package com.example.kotlinproject_3.controller

import com.example.kotlinproject_3.domain.entity.Comment
import com.example.kotlinproject_3.service.CommentService
import com.example.kotlinproject_3.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CommentController(
    @Autowired private val commentService: CommentService,
    @Autowired private val postService: PostService
) {
    @PostMapping("/posts/{postId}/comments")
    fun createComment(@RequestBody comment: Comment,@PathVariable postId: Long){
        val post = postService.getPost(postId)

        commentService.saveComment(comment, post)
    }

    @DeleteMapping("/comments/{commentId}")
    fun deleteComment(@PathVariable commentId: Long){
        commentService.deleteComment(commentId)
    }
}