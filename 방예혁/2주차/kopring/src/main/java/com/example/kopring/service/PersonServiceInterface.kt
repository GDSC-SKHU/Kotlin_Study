package com.example.kopring.service

import com.example.kopring.domain.Person

interface PersonServiceInterface {

    fun findAll(): List<Person>

    fun findById(id: Long): Person

    fun create(person: Person): Person

    fun edit(id: Long, person: Person): Person

    fun delete(id: Long): String

}