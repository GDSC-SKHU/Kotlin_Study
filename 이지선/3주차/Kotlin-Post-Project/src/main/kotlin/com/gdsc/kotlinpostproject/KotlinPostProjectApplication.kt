package com.gdsc.kotlinpostproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class KotlinPostProjectApplication

fun main(args: Array<String>) {
	runApplication<KotlinPostProjectApplication>(*args)
}
