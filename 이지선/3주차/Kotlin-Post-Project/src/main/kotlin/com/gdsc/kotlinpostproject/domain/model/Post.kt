package com.gdsc.kotlinpostproject.domain.model

import com.gdsc.kotlinpostproject.common.BaseTime
import jakarta.persistence.*


@Table(name = "post")
@Entity
class Post (
    title: String,
    content: String,
        ): BaseTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long = 0
        protected set

    @Column(nullable = false)
    var title: String = title
        protected set

    @Column(nullable = false, length = 3000)
    var content: String = content
        protected set

    @OneToMany(mappedBy = "post",
        cascade = [CascadeType.ALL],
        orphanRemoval = true)
    @OrderBy("created_at asc")
    val comments: MutableList<Comment> = mutableListOf()

    fun updatePost(title: String, content: String) {
        this.title = title
        this.content = content
    }
}