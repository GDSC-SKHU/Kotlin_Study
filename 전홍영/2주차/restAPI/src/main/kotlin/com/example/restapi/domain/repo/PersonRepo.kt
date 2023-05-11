package com.example.restapi.domain.repo

import com.example.restapi.domain.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepo : JpaRepository<Person, Long> {
}