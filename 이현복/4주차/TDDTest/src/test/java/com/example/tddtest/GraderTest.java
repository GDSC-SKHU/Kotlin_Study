package com.example.tddtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {
    @Test
    void 오십구는F다(){
        var grader = new Grader();
        assertEquals('F', grader.determineLetterGrade(59));
    }

    @Test
    void 육십구는D다(){
        var grader = new Grader();
        assertEquals('D', grader.determineLetterGrade(69));
    }
    @Test
    void 칠십구는C다(){
        var grader = new Grader();
        assertEquals('C', grader.determineLetterGrade(79));
    }
    @Test
    void 오류내볼게(){
        var grader = new Grader();
        assertEquals('A', grader.determineLetterGrade(69));
    }


    @Test
    void 팔십구는B다(){
        var grader = new Grader();
        assertEquals('B', grader.determineLetterGrade(89));
    }
    @Test
    void 구십구는A다(){
        var grader = new Grader();
        assertEquals('A', grader.determineLetterGrade(99));
    }

    @Test
    void 테스트실패시IllegalArgumentException호출(){
        var grader = new Grader();
        // Test가 실패하면 예외처리 되는지 확인하기
        assertThrows(IllegalArgumentException.class,
                () -> {
                    grader.determineLetterGrade(-1);
                });
    }


}