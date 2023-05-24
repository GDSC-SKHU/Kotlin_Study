package com.example.kotlin_4th.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Builder

@Entity
class Person(
    var name: String,
    var age: Int,
    var gender: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun update(name: String, age: Int, gender: String) {
        this.name = name
        this.age = age
        this.gender = gender
    }
}