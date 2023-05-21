package com.example.kotlinproject_3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class KotlinProject3Application

fun main(args: Array<String>) {
	runApplication<KotlinProject3Application>(*args)
}
