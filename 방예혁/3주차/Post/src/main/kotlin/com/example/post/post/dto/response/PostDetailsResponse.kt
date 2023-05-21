package com.example.post.post.dto.response

import com.example.post.post.domain.Post
import java.time.LocalDateTime

data class PostDetailsResponse(

    val id: Long,

    val writer: String,

    val title: String,

    val content: String,

    val comments: List<CommentResponse>,

    val createdDate: LocalDateTime,

    val modifiedDate: LocalDateTime,

    ) {

    companion object {
        fun of(post: Post): PostDetailsResponse {
            return PostDetailsResponse(
                id = post.postId!!,
                writer = post.writer!!,
                title = post.title!!,
                content = post.content!!,
                comments = post.comments?.map { CommentResponse.of(it) } ?: listOf(),
                createdDate = post.createdAt,
                modifiedDate = post.modifiedAt,
            )
        }
    }

}