package com.example.restapi.controller

import com.example.restapi.domain.entity.Person
import com.example.restapi.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/api/persons")
class PersonController(
   private val perSonService: PersonService
) {
   @GetMapping("")
   fun findAll() = ResponseEntity.ok(perSonService.findAll())

   @GetMapping("/{id}")
   fun findById(@PathVariable id: Long) = ResponseEntity.ok(perSonService.findById(id))

   @PostMapping("")
   fun save(@RequestBody person: Person) = ResponseEntity.ok(perSonService.save(person))

   @DeleteMapping("/{id}")
   fun deleteById(@PathVariable id: Long) = ResponseEntity.ok(perSonService.deleteById(id))

   @PatchMapping("/{id}")
   fun updateById(
      @PathVariable id: Long,
      @RequestParam(name = "name") name: String,
      @RequestParam(name = "age") age: Int,
      @RequestParam(name = "gender") gender: String
   ) = ResponseEntity.ok(perSonService.updateById(id, name, age, gender))

}