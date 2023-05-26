package com.example.kotlin_4th.service

import com.example.kotlin_4th.domain.entity.Person
import com.example.kotlin_4th.domain.repo.PersonRepo
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class PersonServiceTest {
    @MockK
    private val personRepo = mockk<PersonRepo>()

    @InjectMockKs
    private val personService = PersonService(personRepo)

    @Test
    fun `사람을 저장한다`() {
        //given
        every { personRepo.save(any()) } returns Person("홍길동", 20, "남자")
        //when
        val person = personService.save(Person("홍길동", 20, "남자"))
        //then
        assertEquals("홍길동", person.name)
    }

    @Test
    fun `ID에 맞는 사람을 조회한다`() {
        //given
        every { personRepo.findById(any()) } returns Optional.of(Person("홍길동", 20, "남자"))
        //when
        val person = personService.findById(1L)
        //then
        assertEquals("홍길동", person.name)
    }

    @Test
    fun `ID에 해당하는 사람이 없으면 오류를 던진다`() {
        //given
        every { personRepo.findById(any())} returns Optional.empty()
        //when && then
        assertThrows(IllegalArgumentException::class.java) {
            personService.findById(1L)
        }
    }

    @Test
    fun `ID에 해당하는 사람을 찾아 필드를 수정한다`() {
        //given
        every { personRepo.findById(any()) } returns Optional.of(Person("홍길동", 20, "남자"))
        //when
        val person = personService.update(1L, "홍길동2", 30, "여자")
        //then
        assertAll(
            "person",
            { assertEquals("홍길동2", person.name) },
            { assertEquals(30, person.age) },
            { assertEquals("여자", person.gender) }
        )
    }
}