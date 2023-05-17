package com.example.post.Service

import com.example.post.Entity.Post
import com.example.post.Repository.PostRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class PostService(
        private val postRepository: PostRepository
) {
    fun findAll() : List<Post> = postRepository.findAll()

    fun findById(id:Long) : Post = postRepository.findById(id)
            .orElseThrow{ ChangeSetPersister.NotFoundException() }

    fun createPost(post:Post) = postRepository.save(post)

    fun updatePost(id:Long, post: Post) {
        val findPost : Post = findById(id)
        findPost.update(post)
        postRepository.save(findPost)
    }

    fun deletePost(id: Long) {
        val findPost : Post = findById(id)
        postRepository.delete(findPost)
    }
}