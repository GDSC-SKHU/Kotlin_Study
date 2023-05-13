package com.example.post.post.app

import com.example.post.post.app.interfaces.PostServiceInterface
import com.example.post.post.dao.PostRepository
import com.example.post.post.dto.request.PostWrite
import com.example.post.post.dto.response.PostResponse
import com.example.post.post.dto.response.PostDetailsResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalStateException

@Service
class PostService(private val postRepository: PostRepository): PostServiceInterface {

    @Transactional(readOnly = true)
    override fun findAll(): List<PostResponse> {
        return postRepository.findAll().map { PostResponse.of(it) }
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): PostDetailsResponse {
        val post = postRepository.findByPostId(id) ?: throw IllegalStateException("Post Not Found")
        return PostDetailsResponse.of(post)
    }

    @Transactional
    override fun write(request: PostWrite): PostDetailsResponse {
        return PostDetailsResponse.of(postRepository.save(request.toEntity()))
    }

    @Transactional
    override fun edit(id: Long, request: PostWrite): PostDetailsResponse {
        val post = postRepository.findByPostId(id) ?: throw IllegalStateException("Post Not Found")
        post.update(request.title, request.content)
        return PostDetailsResponse.of(postRepository.save(post))
    }

    @Transactional
    override fun delete(id: Long): String {
        val post = postRepository.findByPostId(id) ?: throw IllegalStateException("Post Not Found")
        postRepository.delete(post)
        return "Deleted Post"
    }

}