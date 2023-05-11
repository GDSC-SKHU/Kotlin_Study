package com.example.kopring.controller

import com.example.kopring.domain.Person
import com.example.kopring.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.IllegalStateException

@RestController
@RequestMapping("/api")
class PersonController(private val personService: PersonService) {

    // 전체 인원 정보 조회
    @GetMapping("person/list")
    fun findAllPerson(): ResponseEntity<List<Person>> {
        return ResponseEntity(personService.findAll(), HttpStatus.OK)
    }

    // id가 일치하는 인원 정보 조회
    @GetMapping("person/{id}")
    fun findPerson(@PathVariable("id") id: Long): ResponseEntity<*> {
        return try {
            ResponseEntity(personService.findById(id), HttpStatus.OK)
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    // 인원 정보 생성
    @PostMapping("person/create")
    fun createPerson(@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity<Person>(personService.create(person), HttpStatus.OK)
    }

    // id가 일치하는 인원 정보 수정
    @PutMapping("person/{id}")
    fun editPerson(@PathVariable("id") id: Long, @RequestBody person: Person): ResponseEntity<*> {
        return try {
            ResponseEntity(personService.edit(id, person), HttpStatus.OK)
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    // id가 일치하는 인원 정보 삭제
    @DeleteMapping("person/{id}")
    fun deletePerson(@PathVariable("id") id: Long): ResponseEntity<String> {
        return try {
            ResponseEntity<String>(personService.delete(id), HttpStatus.OK)
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

}