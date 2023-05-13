package com.example.post.post.app.interfaces

import com.example.post.post.dto.request.PostWrite
import com.example.post.post.dto.response.PostResponse
import com.example.post.post.dto.response.PostDetailsResponse

interface PostServiceInterface {

    fun findAll(): List<PostResponse>

    fun findById(id: Long): PostDetailsResponse

    fun write(request: PostWrite): PostDetailsResponse

    fun edit(id: Long, request: PostWrite): PostDetailsResponse

    fun delete(id: Long): String

}