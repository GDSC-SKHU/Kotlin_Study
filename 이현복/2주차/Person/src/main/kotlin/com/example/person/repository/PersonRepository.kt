package com.example.person.repository

import com.example.person.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person,Long> {
}