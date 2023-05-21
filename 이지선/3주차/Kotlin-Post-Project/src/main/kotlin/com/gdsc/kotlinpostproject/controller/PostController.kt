package com.gdsc.kotlinpostproject.controller

import com.gdsc.kotlinpostproject.domain.model.Post
import com.gdsc.kotlinpostproject.service.PostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/posts")
@RestController
class PostController (
    private val postService: PostService
        ){
    @GetMapping("")
    fun findAllPosts() : ResponseEntity<List<Post>> {
        return ResponseEntity.ok(postService.findAll())
    }

    @PostMapping("")
    fun createPost(@RequestBody post: Post) : ResponseEntity<Post> {
        return ResponseEntity.ok(postService.create(post))
    }

    @GetMapping("/{postId}")
    fun findPost(@PathVariable postId: Long) : ResponseEntity<Post> {
        return ResponseEntity.ok(postService.findById(postId))
    }

    @PatchMapping("/{postId}")
    fun update(@PathVariable postId: Long, @RequestBody post: Post): ResponseEntity<Post> {
        return ResponseEntity.ok(postService.update(postId, post))
    }

    @DeleteMapping("/{postId}")
    fun delete(@PathVariable postId: Long): ResponseEntity<Unit> {
        return ResponseEntity.ok(postService.delete(postId))
    }
}