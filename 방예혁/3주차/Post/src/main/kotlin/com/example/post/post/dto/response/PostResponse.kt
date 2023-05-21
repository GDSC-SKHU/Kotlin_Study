package com.example.post.post.dto.response

import com.example.post.post.domain.Post
import java.time.LocalDateTime

data class PostResponse(

    val id: Long,

    val writer: String,

    val title: String,

    val createdDate: LocalDateTime,

    val modifiedDate: LocalDateTime,

    ) {

    companion object {
        fun of(post: Post): PostResponse {
            return PostResponse(
                id = post.postId!!,
                writer = post.writer!!,
                title = post.title!!,
                createdDate = post.createdAt,
                modifiedDate = post.modifiedAt,
            )
        }
    }
}