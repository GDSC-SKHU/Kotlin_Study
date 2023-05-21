package com.gdsc.kotlinpostproject.domain.repo

import com.gdsc.kotlinpostproject.domain.model.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
}