package com.gdsc.kotlinpostproject.service

import com.gdsc.kotlinpostproject.domain.model.Comment
import com.gdsc.kotlinpostproject.domain.model.Post
import com.gdsc.kotlinpostproject.domain.repo.CommentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService (
    private val commentRepository: CommentRepository
        ){
    @Transactional
    fun create(post: Post, comment: Comment): Comment {
        comment.updateComment(post)
        return commentRepository.save(comment)
    }

    @Transactional
    fun delete(commentId: Long) {
        commentRepository.deleteById(commentId)
    }
}