package com.gdsc.kotlinpostproject.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.gdsc.kotlinpostproject.common.BaseTime
import jakarta.persistence.*

@Table(name = "comment")
@Entity
class Comment(
    content: String,
    writer: String,
) : BaseTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long = 0
        protected set

    @Column(nullable = false)
    var content: String = content
        protected set

    @Column(nullable = false)
    var writer: String = writer
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonIgnore
    var post: Post ?= null
        protected set

    fun updateComment(post: Post) {
        this.post = post
    }
}