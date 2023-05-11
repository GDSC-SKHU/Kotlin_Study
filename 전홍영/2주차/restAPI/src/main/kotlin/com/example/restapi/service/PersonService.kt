package com.example.restapi.service

import com.example.restapi.domain.entity.Person
import com.example.restapi.domain.repo.PersonRepo
import org.springframework.stereotype.Service

@Service
class PersonService(
    private val personRepo: PersonRepo
) {
    fun findById(id: Long)= personRepo.findById(id)

    fun findAll() = personRepo.findAll()

    fun save(person: Person) = personRepo.save(person)

    fun deleteById(id: Long) = personRepo.deleteById(id)

    fun updateById(id: Long, name: String, age: Int, gender: String) {
        val person: Person = personRepo.findById(id).get()

        val updatePerson = person.update(name, age, gender)

        personRepo.save(updatePerson)
    }

}