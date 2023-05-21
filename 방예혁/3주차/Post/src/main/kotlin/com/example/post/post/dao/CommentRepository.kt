package com.example.post.post.dao

import com.example.post.post.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {

    fun findByCommentId(id: Long): Comment?

}