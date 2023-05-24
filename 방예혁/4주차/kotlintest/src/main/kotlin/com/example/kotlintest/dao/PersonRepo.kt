package com.example.kotlintest.dao

import com.example.kotlintest.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepo: JpaRepository<Person, Long> {

    fun findByNameAndGender(name: String, gender: String): Person?

}