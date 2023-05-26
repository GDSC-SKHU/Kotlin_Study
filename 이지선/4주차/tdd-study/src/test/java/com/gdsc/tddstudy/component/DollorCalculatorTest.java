package com.gdsc.tddstudy.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest     // 모든 객체가 Bean에 등록되어 따로 import할 필요X
public class DollorCalculatorTest {

    // Spring은 Bean을 사용하기 때문에 Mock이 아닌 MockBean 사용
    @MockBean
    private MarketApi marketApi;

    @Autowired
    private DollorCalculator dollorCalculator;

    // DollorCalculator 클래스의 sum()과 minus() 메서드가 예상대로 작동하는지를 검증
    @Test
    public void dollorCalculatorTest() {
        // marketApi.connect() 메서드가 호출되었을 때 3000을 반환하도록 설정
        Mockito.when(marketApi.connect()).thenReturn(3000);
        dollorCalculator.init();

        int sum = dollorCalculator.sum(10, 10);
        int minus = dollorCalculator.minus(10, 10);

        
        // 예상 결과와 실제 결과의 일치 여부 비교
        Assertions.assertEquals(60000, sum);
        Assertions.assertEquals(0, minus);
    }
}
