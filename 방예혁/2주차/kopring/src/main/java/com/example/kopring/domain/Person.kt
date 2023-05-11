package com.example.kopring.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
class Person (

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

    // 인원 정보 수정
    fun editPersonInfo(person: Person) {
        this.name = person.name
        this.age = person.age
        this.gender = person.gender
    }

}
