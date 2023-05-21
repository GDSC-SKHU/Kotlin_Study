package com.example.kotlinproject_3.service

import com.example.kotlinproject_3.domain.entity.Comment
import com.example.kotlinproject_3.domain.entity.Post
import com.example.kotlinproject_3.domain.repo.CommentRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService(private val commentRepo: CommentRepo){
    @Transactional
    fun saveComment(comment: Comment,post: Post){
        comment.post = post
        commentRepo.save(comment)
    }

    @Transactional
    fun deleteComment(id: Long) = commentRepo.deleteById(id)
}