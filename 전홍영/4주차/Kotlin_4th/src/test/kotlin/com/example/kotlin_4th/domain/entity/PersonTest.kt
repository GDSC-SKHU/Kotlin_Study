package com.example.kotlin_4th.domain.entity

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonTest {
    @Test
    fun `사람을 생성한다`() {
        //given & when
        var person : Person = Person("홍길동", 20, "남자")
        //then
        assertThat(person.name).isEqualTo("홍길동")
    }

    @Test
    fun `사람의 필드를 수정할 수 있다`(){
        //given
        var person : Person = Person("홍길동", 20, "남자")

        var name : String = "홍길동2"

        var age : Int = 21

        var gender : String = "여자"
        //when
        person.update(name, age, gender)
        //then
        assertAll(
            "person",
            { assertEquals("홍길동2", person.name) },
            { assertEquals(21, person.age) },
            { assertEquals("여자", person.gender) }
        )
    }
}