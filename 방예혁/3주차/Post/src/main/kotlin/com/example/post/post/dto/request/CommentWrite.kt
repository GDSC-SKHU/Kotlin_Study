package com.example.post.post.dto.request

data class CommentWrite(

    val writer: String?,

    val comment: String?,

    val postId: Long?,

    ) {

}