package com.example.kotlinproject_3.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Post(
    var title: String ="",
    var content: String,
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column
    val createAt: LocalDate = LocalDate.now()

    @Column
    var updateAt: LocalDate = LocalDate.now()

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], orphanRemoval = true)
    val comments: MutableList<Comment> = mutableListOf()
}