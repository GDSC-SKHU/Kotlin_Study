package com.example.kotlin_4th.service

import com.example.kotlin_4th.domain.entity.Person
import com.example.kotlin_4th.domain.repo.PersonRepo
import org.springframework.stereotype.Service

@Service
class PersonService(val personRepo: PersonRepo) {
    fun save(person: Person): Person = personRepo.save(person)

    fun findById(id: Long): Person = personRepo.findById(id).orElseThrow{ throw IllegalArgumentException("해당하는 ID가 없습니다.")}

    fun update(id: Long, name: String, age: Int, gender: String): Person {
        val person = findById(id)

        person.update(name, age, gender)

        return person
    }
}