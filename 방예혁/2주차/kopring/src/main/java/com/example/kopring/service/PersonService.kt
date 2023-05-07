package com.example.kopring.service

import com.example.kopring.domain.Person
import com.example.kopring.repository.PersonRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalStateException
import java.util.Optional

@Service
class PersonService(private val personRepository: PersonRepository): PersonServiceInterface {

    @Transactional(readOnly = true)
    override fun findAll(): List<Person> {
        return personRepository.findAll()
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): Person {
        val optionalPerson: Optional<Person> = personRepository.findById(id)

        if (optionalPerson.isPresent) run {
            // id가 일치하는 인원이 존재하는 경우 해당 인원 정보 반환
            return optionalPerson.get()
        } else {
            throw IllegalStateException("Person(ID: $id) 존재하지 않습니다")
        }
    }

    @Transactional
    override fun create(person: Person): Person {
        return personRepository.save(person)
    }

    @Transactional
    override fun edit(id: Long, person: Person): Person {
        val optionalPerson: Optional<Person> = personRepository.findById(id)

        if (optionalPerson.isPresent) run {
            // id가 일치하는 인원이 존재하는 경우 해당 인원 정보 수정
            val updatePerson: Person = optionalPerson.get()
            updatePerson.editPersonInfo(person)
            return personRepository.save(updatePerson)
        } else {
            throw IllegalStateException("Person(ID: $id) 존재하지 않습니다")
        }
    }

    @Transactional
    override fun delete(id: Long): String {
        val optionalPerson: Optional<Person> = personRepository.findById(id)

        if (optionalPerson.isPresent) run {
            // id가 일치하는 인원이 존재하는 경우 해당 인원 정보 삭제
            personRepository.deleteById(id)
            return "Person(ID: $id) 삭제 완료되었습니다"
        } else {
            throw IllegalStateException("Person(ID: $id) 존재하지 않습니다")
        }
    }

}