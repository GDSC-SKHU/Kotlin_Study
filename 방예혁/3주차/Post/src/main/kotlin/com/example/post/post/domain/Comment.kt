package com.example.post.post.domain

import com.example.post.global.basetime.BaseTime
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Entity
class Comment (

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var commentId: Long? = null,

    @Column(nullable = false)
    var writer: String? = null,

    @Column(nullable = false)
    var comment: String? = null,

    @ManyToOne
    @JoinColumn(name = "post_id")
    var post: Post

): BaseTime() {

    fun update(comment: String?) {
        this.comment = comment ?: ""
    }

}
