package com.example.person.service

import com.example.person.entity.Person
import com.example.person.repository.PersonRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class PersonService(
        private val personRepository: PersonRepository
) {
    fun findAll() : List<Person> = personRepository.findAll();

    fun findById(id:Long) : Person = personRepository.findById(id)
            .orElseThrow{NotFoundException()}

    fun createPerson(person: Person) = personRepository.save(person);

    fun deletePerson(id:Long) {
        val findPerson: Person = findById(id)
        personRepository.delete(findPerson)
    }

    fun updatePerson(id:Long, updatePerson: Person) {
        val findPerson: Person = findById(id)

        findPerson.updatePerson(updatePerson);
        personRepository.save(findPerson);
    }
}