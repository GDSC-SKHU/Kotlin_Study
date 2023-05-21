package com.example.post.post.app.interfaces

import com.example.post.post.dto.request.CommentWrite
import com.example.post.post.dto.response.CommentResponse

interface CommentServiceInterface {

    fun write(request: CommentWrite): CommentResponse

    fun edit(id: Long, request: CommentWrite): CommentResponse

    fun delete(id: Long): String

}