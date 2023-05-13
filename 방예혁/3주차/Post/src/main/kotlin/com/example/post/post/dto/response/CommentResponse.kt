package com.example.post.post.dto.response

import com.example.post.post.domain.Comment
import java.time.LocalDateTime

data class CommentResponse(

    val id: Long,

    val writer: String,

    val comment: String,

    val createdDate: LocalDateTime,

    val modifiedDate: LocalDateTime,

    ) {

    companion object {
        fun of(comment: Comment): CommentResponse {
            return CommentResponse(
                id = comment.commentId!!,
                writer = comment.writer!!,
                comment = comment.comment!!,
                createdDate = comment.createdAt,
                modifiedDate = comment.modifiedAt,
            )
        }
    }

}
