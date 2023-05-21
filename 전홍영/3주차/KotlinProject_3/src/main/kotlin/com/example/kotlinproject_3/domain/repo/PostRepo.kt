package com.example.kotlinproject_3.domain.repo

import com.example.kotlinproject_3.domain.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepo : JpaRepository<Post, Long>{
}