package com.example.kotlinproject_3.domain.repo

import com.example.kotlinproject_3.domain.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepo: JpaRepository<Comment, Long> {
}