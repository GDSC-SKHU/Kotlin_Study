package com.example.person.controller

import com.example.person.entity.Person
import com.example.person.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class PersonController(
        private val personService: PersonService
) {
    @GetMapping("/test")
    fun test() = ResponseEntity.ok("test")

    @GetMapping("")
    fun findAll(): ResponseEntity<List<Person>> = ResponseEntity.ok(personService.findAll())

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Long) : ResponseEntity<Person> = ResponseEntity.ok(personService.findById(id))

    @PostMapping("")
    fun save(@RequestBody person: Person) = ResponseEntity.ok(personService.createPerson(person))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : Long) = ResponseEntity.ok(personService.deletePerson(id))

    @PatchMapping("/{id}")
    fun update(@PathVariable id : Long, @RequestBody person: Person)
        = ResponseEntity.ok(personService.updatePerson(id, person))

}