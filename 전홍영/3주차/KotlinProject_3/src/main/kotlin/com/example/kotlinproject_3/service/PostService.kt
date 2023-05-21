package com.example.kotlinproject_3.service

import com.example.kotlinproject_3.domain.entity.Post
import com.example.kotlinproject_3.domain.repo.PostRepo
import com.example.kotlinproject_3.dto.PostRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(private val postRepo: PostRepo) {
    @Transactional
    fun savePost(postRequest: PostRequest){
        Post(
            title = postRequest.title,
            content = postRequest.content
        ).let(postRepo::save)
    }

    @Transactional(readOnly = true)
    fun getPost(id: Long) : Post = postRepo.findById(id).orElseThrow()

    @Transactional
    fun deletePost(id: Long) = postRepo.deleteById(id)
}