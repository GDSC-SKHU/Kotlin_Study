package com.gdsc.kotlinfirstproject.service

import com.gdsc.kotlinfirstproject.domain.entity.Person
import com.gdsc.kotlinfirstproject.domain.repo.PersonRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PersonService (
    private val personRepository : PersonRepository
    ) {
    @Transactional(readOnly = true)
    fun findAll(): List<Person> {
        return personRepository.findAll()
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): Person {
        return personRepository.findById(id).get()
    }

    @Transactional
    fun create(board: Person): Person {
        return personRepository.save(board)
    }

    @Transactional
    fun update(id: Long, updatePerson: Person): Person {
        var person: Person = personRepository.findById(id).get()
        person.updatePerson(updatePerson)
        return person
    }

    @Transactional
    fun delete(id: Long) {
        personRepository.deleteById(id)
    }
}
