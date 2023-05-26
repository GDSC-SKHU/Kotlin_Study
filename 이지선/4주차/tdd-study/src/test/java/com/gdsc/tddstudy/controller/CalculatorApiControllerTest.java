package com.gdsc.tddstudy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdsc.tddstudy.component.Calculator;
import com.gdsc.tddstudy.component.DollorCalculator;
import com.gdsc.tddstudy.component.MarketApi;
import com.gdsc.tddstudy.dto.Req;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorApiController.class)              // Spring MVC 컨트롤러를 테스트하기 위한 어노테이션
@AutoConfigureWebMvc                                    // 서버를 시작하지 않고 아래 계층만 테스트
@Import({Calculator.class, DollorCalculator.class})     // 필요한 class를 import
public class CalculatorApiControllerTest {

    @MockBean
    private MarketApi marketApi;

    // mvc를 모킹으로 테스트
    // 모킹: 테스트하려는 코드에 외부 의존성이 있을 때 단위 테스트에서 사용되는 프로세스. 모킹을 함으로서 실제 객체를 가짜 객체로 대체
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach     // 각 테스트 코드가 실행되기 전에 호출
    public void init() {
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void sumTest() throws Exception {
        // HTTP 요청을 모방하여 컨트롤러를 테스트하는 데 사용되는 MockMvc의 메서드
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/api/sum")     // get 요청 생성
                        .queryParam("x","10")
                        .queryParam("y", "10")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()       // 예상되는 응답 200(OK)
        ).andExpect(
                MockMvcResultMatchers.content().string("60000")     // 응답 본문에 60000이 포함되어있어야 함
        ).andDo(MockMvcResultHandlers.print());     // 응답을 콘솔에 출력
    }

    @Test
    public void minusTest() throws Exception {
        Req req = new Req();
        req.setX(10);
        req.setY(10);

        String json = new ObjectMapper().writeValueAsString(req);

        mockMvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8080/api/minus")      // post 요청 생성
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()       // 응답의 필드들이 예상된 값과 일치하는지 확인
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.result").value("0")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")
        ).andDo(MockMvcResultHandlers.print());
    }

}
