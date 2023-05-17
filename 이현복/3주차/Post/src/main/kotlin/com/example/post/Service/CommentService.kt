package com.example.post.Service

import com.example.post.Entity.Comment
import com.example.post.Entity.Post
import com.example.post.Repository.CommentRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class CommentService(
        private val commentRepository: CommentRepository,
        private val postService: PostService
) {


    fun findById(id:Long) : Comment = commentRepository.findById(id)
            .orElseThrow{ ChangeSetPersister.NotFoundException() }

    fun createComment(postId : Long, comment: Comment) {
        comment.post = postService.findById(postId)
        commentRepository.save(comment)
    }

    fun deleteComment(id: Long) {
        val findPost : Comment = findById(id)
        commentRepository.delete(findPost)
    }
}