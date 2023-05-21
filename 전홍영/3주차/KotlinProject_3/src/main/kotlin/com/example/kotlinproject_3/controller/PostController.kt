package com.example.kotlinproject_3.controller

import com.example.kotlinproject_3.domain.entity.Post
import com.example.kotlinproject_3.dto.PostRequest
import com.example.kotlinproject_3.service.PostService
import org.springframework.web.bind.annotation.*

@RestController
class PostController (private val postService: PostService){
    @PostMapping("/posts")
    fun createPost(@RequestBody postRequest: PostRequest) = postService.savePost(postRequest)

    @GetMapping("/posts/{postId}")
    fun getPost(@PathVariable postId: Long) : Post = postService.getPost(postId)

    @DeleteMapping("/posts/{postId}")
    fun deletePost(@PathVariable postId: Long) = postService.deletePost(postId)
}