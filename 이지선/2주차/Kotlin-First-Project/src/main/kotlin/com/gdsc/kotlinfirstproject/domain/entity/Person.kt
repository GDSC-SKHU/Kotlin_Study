package com.gdsc.kotlinfirstproject.domain.entity

import jakarta.persistence.*

@Table(name = "person")
@Entity
data class Person (
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

    fun updatePerson(person: Person) {
        this.name = person.name
        this.age = person.age
        this.gender = person.gender
    }
}