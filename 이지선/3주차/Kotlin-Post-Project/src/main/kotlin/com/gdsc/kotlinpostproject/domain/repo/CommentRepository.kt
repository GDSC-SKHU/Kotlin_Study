package com.gdsc.kotlinpostproject.domain.repo

import com.gdsc.kotlinpostproject.domain.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
}