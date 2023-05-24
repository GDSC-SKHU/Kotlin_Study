package com.example.kotlin_4th.domain.repo

import com.example.kotlin_4th.domain.entity.Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@DataJpaTest
@ExtendWith(SpringExtension::class)
internal class PersonRepoTest(@Autowired val personRepo: PersonRepo) {
    @Test
    fun `사람을 저장한다`() {
        //given
        var person: Person = Person("홍길동", 20, "남자")
        //when
        val savePerson = personRepo.save(person)
        //then
        assertThat(savePerson).isEqualTo(person)
    }

    @Test
    fun `ID에 맞는 사람을 조회한다`() {
        //given
        var person: Person = Person("홍길동", 20, "남자")

        val savePerson = personRepo.save(person)
        //when
        val findPerson = personRepo.findById(savePerson.id!!).get()
        //then
        assertThat(findPerson).isEqualTo(savePerson)
    }

}