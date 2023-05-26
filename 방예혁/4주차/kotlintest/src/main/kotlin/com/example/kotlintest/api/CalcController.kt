package com.example.kotlintest.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalcController {

    @GetMapping("/sum")
    fun sum(@RequestParam a: Int, @RequestParam b: Int): String {
        return (a + b).toString()
    }

    @GetMapping("/minus")
    fun minus(@RequestParam a: Int, @RequestParam b: Int): String {
        return (a - b).toString()
    }

}