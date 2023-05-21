package com.example.post.Controller

import com.example.post.Entity.Comment
import com.example.post.Entity.Post
import com.example.post.Service.CommentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comment")
class CommentController (
        private val commentService: CommentService
){
    @PostMapping("/{postId}/create")
    fun create(@PathVariable postId : Long, @RequestBody comment: Comment) : String {
        commentService.createComment(postId, comment)
        return "create success"
    }

    @DeleteMapping("/{id}/delete")
    fun delete(@PathVariable id: Long) : String {
        commentService.deleteComment(id)
        return "delete success"
    }
}