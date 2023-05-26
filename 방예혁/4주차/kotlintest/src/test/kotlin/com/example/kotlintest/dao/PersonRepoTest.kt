package com.example.kotlintest.dao

import com.example.kotlintest.domain.Person

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepoTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val personRepo: PersonRepo,
) {

    @DisplayName("새로운 Person 저장 테스트")
    @Test
    fun `save new person`() {
        // given
        val person = Person(name = "홍길동", age = 30, gender = "남성")

        // when
        val savedPerson = personRepo.save(person)

        // then
        assertNotNull(savedPerson.id)
        assertEquals(person.name, savedPerson.name)
        assertEquals(person.age, savedPerson.age)
        assertEquals(person.gender, savedPerson.gender)
    }

    @DisplayName("이름과 성별로 Person 찾기 테스트")
    @Test
    fun `find person by name and gender`() {
        // given
        val person = Person(name = "홍길동", age = 30, gender = "남성")
        entityManager.persistAndFlush(person)

        // when
        val foundPerson = personRepo.findByNameAndGender("홍길동", "남성") ?: throw Exception("Person not found")

        // then
        assertNotNull(foundPerson)
        assertEquals(person, foundPerson)
    }

}