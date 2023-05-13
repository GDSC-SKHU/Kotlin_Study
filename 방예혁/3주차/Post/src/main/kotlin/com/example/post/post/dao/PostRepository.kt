package com.example.post.post.dao

import com.example.post.post.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Long> {

    fun findByPostId(id: Long): Post?

}