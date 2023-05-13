package com.example.post.post.app

import com.example.post.post.app.interfaces.CommentServiceInterface
import com.example.post.post.dao.CommentRepository
import com.example.post.post.dao.PostRepository
import com.example.post.post.domain.Comment
import com.example.post.post.dto.request.CommentWrite
import com.example.post.post.dto.response.CommentResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalStateException

@Service
class CommentService(private val postRepository: PostRepository,
                     private val commentRepository: CommentRepository): CommentServiceInterface {

    @Transactional
    override fun write(request: CommentWrite): CommentResponse {
        val post = postRepository.findByPostId(request.postId?: throw IllegalStateException("PostId is Null")) ?: throw IllegalStateException("Post Not Found")
        val comment = Comment(
            writer = request.writer,
            comment = request.comment,
            post = post,
        )
        return CommentResponse.of(commentRepository.save(comment))
    }

    @Transactional
    override fun edit(id: Long, request: CommentWrite): CommentResponse {
        val comment = commentRepository.findByCommentId(id) ?: throw IllegalStateException("Comment Not Found")
        comment.update(request.comment)
        return CommentResponse.of(commentRepository.save(comment))
    }

    @Transactional
    override fun delete(id: Long): String {
        val comment = commentRepository.findByCommentId(id) ?: throw IllegalStateException("Comment Not Found")
        commentRepository.delete(comment)
        return "Deleted Comment"
    }

}