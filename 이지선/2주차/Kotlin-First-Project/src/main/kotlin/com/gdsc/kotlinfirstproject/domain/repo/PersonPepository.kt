package com.gdsc.kotlinfirstproject.domain.repo

import com.gdsc.kotlinfirstproject.domain.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long> {
}