package com.example.kotlin_4th.controller

import io.restassured.RestAssured
import io.restassured.response.Response
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonControllerTest {
    @Test
    fun `사람을 저장한다`() {
        //given & when
        val 사람_저장 = RestAssured.given()
            .header("Content-type", "application/json")
            .and()
            .body("{\n" +
                    "  \"name\": \"홍길동\",\n" +
                    "  \"age\": 20,\n" +
                    "  \"gender\": \"남자\" \n}")
        .post("/people")
        //then
        assertAll(
            "사람_저장",
            { assertEquals(200, 사람_저장.statusCode) },
            { assertEquals("홍길동",사람_저장.jsonPath().getString("name")) },
            { assertEquals("20",사람_저장.jsonPath().getString("age")) },
            { assertEquals("남자",사람_저장.jsonPath().getString("gender")) }
        )
    }

    @Test
    fun `ID에 해당하는 사람을 조회한다`(){
        //given
        val (사람_저장, id) = savePersonAndGetId()
        //when
        val 사람_조회 = RestAssured.given()
            .header("Content-type", "application/json")
            .and()
            .get("/people/$id")
        //then
        assertAll(
            "사람_조회",
            { assertEquals(200, 사람_저장.statusCode) },
            { assertEquals("홍길동",사람_조회.jsonPath().getString("name")) },
            { assertEquals("20",사람_조회.jsonPath().getString("age")) },
            { assertEquals("남자",사람_조회.jsonPath().getString("gender")) }
        )
    }

    @Test
    fun `ID에 해당하는 사람을 찾아 받아온 파라미터로 수정한다`(){
        val id = savePersonAndGetId().second
        //when
        val 사람_수정 = RestAssured.given()
            .header("Content-type", "application/json")
            .and()
            .param("name", "홍길동2")
            .param("age",22)
            .param("gender","여자")
            .put("/people/$id")
        //then
        assertAll(
            "사람_수정",
            { assertEquals(200, 사람_수정.statusCode) },
            { assertEquals("홍길동2",사람_수정.jsonPath().getString("name")) },
            { assertEquals("22",사람_수정.jsonPath().getString("age")) },
            { assertEquals("여자",사람_수정.jsonPath().getString("gender")) }
        )
    }


    private fun savePersonAndGetId(): Pair<Response, String> {
        val 사람_저장 = RestAssured.given()
            .header("Content-type", "application/json")
            .and()
            .body(
                "{\n" +
                        "  \"name\": \"홍길동\",\n" +
                        "  \"age\": 20,\n" +
                        "  \"gender\": \"남자\" \n}"
            )
            .post("/people")

        val id = 사람_저장.jsonPath().getString("id")
        return Pair(사람_저장, id)
    }
}