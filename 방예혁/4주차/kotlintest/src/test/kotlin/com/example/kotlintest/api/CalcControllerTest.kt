package com.example.kotlintest.api

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class CalcControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @DisplayName("파라미터 두 개 더하기 테스트")
    @Test
    fun `sum should return the sum of given parameters`() {
        val a = 5
        val b = 2
        val expected = (a + b).toString()

        mockMvc.perform(get("/sum")
            .param("a", a.toString())
            .param("b", b.toString()))
            .andExpect(status().isOk)
            .andExpect(content().string(expected))
    }

    @DisplayName("파라미터 두 개 빼기 테스트")
    @Test
    fun `minus should return the sum of given parameters`() {
        val a = 5
        val b = 2
        val expected = (a - b).toString()

        mockMvc.perform(get("/minus")
            .param("a", a.toString())
            .param("b", b.toString()))
            .andExpect(status().isOk)
            .andExpect(content().string(expected))
    }
}