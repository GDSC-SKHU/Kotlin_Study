package com.example.kotlin_4th.domain.repo

import com.example.kotlin_4th.domain.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepo: JpaRepository<Person, Long> {

}
