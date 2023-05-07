package com.example.kopring.repository

import com.example.kopring.domain.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<Person, Long> {

}