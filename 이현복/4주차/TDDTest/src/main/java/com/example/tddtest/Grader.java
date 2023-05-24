package com.example.tddtest;

public class Grader {
    public char determineLetterGrade ( int numberGrade) {
        if(numberGrade < 0)
            throw new IllegalArgumentException("이 숫자는 등급이 될 수 없다.");
        else if(numberGrade < 60)
            return 'F';
        else if(numberGrade < 70)
            return 'D';
        else if(numberGrade < 80)
            return 'C';
        else if(numberGrade < 90)
            return 'B';
        else
            return 'A';
    }
}
