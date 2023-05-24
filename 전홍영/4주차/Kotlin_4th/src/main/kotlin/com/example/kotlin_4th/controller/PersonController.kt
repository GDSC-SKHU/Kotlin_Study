package com.example.kotlin_4th.controller

import com.example.kotlin_4th.domain.entity.Person
import com.example.kotlin_4th.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(val personService: PersonService) {
    @PostMapping("/people")
    fun save(@RequestBody person: Person) : Person = personService.save(person)

    @GetMapping("/people/{id}")
    fun findById(@PathVariable id: Long) : Person = personService.findById(id)

    @PutMapping("/people/{id}")
    fun update(@PathVariable id:Long, @RequestParam name:String, @RequestParam age: Int, @RequestParam gender:String) = personService.update(id, name, age, gender)

}