package com.example.restapi.domain.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@NoArgsConstructor
@Data
@Entity
class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String? = null,

    @Column(nullable = false)
    var age: Int? = null,

    @Column(nullable = false)
    var gender: String? = null
) {
    fun update(name: String?, age: Int?, gender: String?):Person{
        this.name = name

        this.age = age

        this.gender = gender

        return this
    }
}