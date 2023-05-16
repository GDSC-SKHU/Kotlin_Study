package com.gdsc.kotlinpostproject.service

import com.gdsc.kotlinpostproject.domain.model.Post
import com.gdsc.kotlinpostproject.domain.repo.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService (
    private val postRepository: PostRepository
        ){

    @Transactional(readOnly = true)
    fun findAll(): List<Post> {
        return postRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun findById(postId: Long): Post {
        return postRepository.findById(postId).get()
    }

    @Transactional
    fun create(post: Post): Post {
        return postRepository.save(post)
    }

    @Transactional
    fun update(postId: Long, updatePost: Post): Post {
        var post: Post = postRepository.findById(postId).get()
        post.updatePost(updatePost.title, updatePost.content)
        return post
    }

    @Transactional
    fun delete(id: Long) {
        postRepository.deleteById(id)
    }
}