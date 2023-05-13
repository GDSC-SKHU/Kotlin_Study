package com.example.post.post.domain

import com.example.post.global.basetime.BaseTime
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.RequiredArgsConstructor

@AllArgsConstructor
@RequiredArgsConstructor
@Entity
class Post (

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var postId: Long? = null,

    @Column(nullable = false)
    var writer: String? = null,

    @Column(nullable = false)
    var title: String? = null,

    @Column(nullable = false)
    var content: String? = null,

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @OrderBy("id asc")
    var comments: MutableList<Comment>?

): BaseTime() {

    fun update(title: String?, content: String?) {
        this.title = title ?: ""
        this.content = content ?: ""
    }

}
