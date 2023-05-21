package com.example.post

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class PostApplication

fun main(args: Array<String>) {
    runApplication<PostApplication>(*args)
}
