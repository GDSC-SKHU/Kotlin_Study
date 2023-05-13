package com.example.post.post.dto.request

import com.example.post.post.domain.Post

data class PostWrite(

    val writer: String,

    val title: String,

    var content: String

    ) {

    fun toEntity(): Post {
        return Post(
            writer = writer,
            title = title,
            content = content,
            comments = null,
        )
    }

}
