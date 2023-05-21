package com.example.post.Controller

import com.example.post.Entity.Post
import com.example.post.Service.PostService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController (
        private val postService: PostService
){
    @GetMapping("")
    fun findAll() : List<Post> = postService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Long) : Post = postService.findById(id)

    @PostMapping("/create")
    fun create(@RequestBody post: Post) : String {
        postService.createPost(post)
        return "create success"
    }

    @PatchMapping("/{id}/update")
    fun update(@RequestBody post: Post, @PathVariable id: Long) : String {
        postService.updatePost(id, post)
        return "update success"
    }

    @DeleteMapping("/{id}/delete")
    fun delete(@PathVariable id: Long) : String {
        postService.deletePost(id)
        return "delete success"
    }
}