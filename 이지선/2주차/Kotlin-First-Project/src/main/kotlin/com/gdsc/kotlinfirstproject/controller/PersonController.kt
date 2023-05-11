package com.gdsc.kotlinfirstproject.controller

import com.gdsc.kotlinfirstproject.domain.entity.Person
import com.gdsc.kotlinfirstproject.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/persons")
@RestController
class PersonController (
        private val personService: PersonService
        ){
        @GetMapping("")
        fun findAllPersons(): ResponseEntity<List<Person>> {
                return ResponseEntity.ok(personService.findAll())
        }

        @GetMapping("/{id}")
        fun findPerson(@PathVariable("id") id: Long): ResponseEntity<Person> {
                return ResponseEntity.ok(personService.findById(id))
        }

        @PostMapping("")
        fun create(@RequestBody person: Person): ResponseEntity<Person> {
                return ResponseEntity.ok(personService.create(person))
        }

        @PatchMapping("/{id}")
        fun update(@PathVariable id: Long, @RequestBody person: Person): ResponseEntity<Person> {
                return ResponseEntity.ok(personService.update(id, person))
        }

        @DeleteMapping("/{id}")
        fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
                return ResponseEntity.ok(personService.delete(id))
        }
}