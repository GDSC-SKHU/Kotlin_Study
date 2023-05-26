package com.example.tddtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleAlgorithmTest {


    // 레퍼런스 : https://www.youtube.com/watch?v=vZm0lHciFsQ&ab_channel=CodingwithJohn
    @Test
    void 이더하기이는사() {
        SimpleAlgorithm algorithm = new SimpleAlgorithm();
        // 결과 맞으면 true 아니면 false
//        assertEquals(4, algorithm.add(2,2));
        // 이런것도 있다~
        assertTrue(algorithm.add(2,2) == 4);
    }

}