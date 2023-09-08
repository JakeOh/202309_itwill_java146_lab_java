package com.itwill.condition01;

public class ConditionMain01 {

    public static void main(String[] args) {
        // 조건문(conditional statement)
        
        int number = 100;
        if (number > 0) {
            // 조건식을 만족하는 경우에 실행할 코드 블록
            System.out.println("양수");
        }
        
        if (number % 2 == 0) { // 만약 number를 2로 나눈 나머지가 0이면(짝수이면)
            // (1) 조건식을 만족하는 경우에 실행할 코드 블록
            System.out.println("짝수");
        } else {
            // (2) 조건식을 만족하지 않는 경우에 실행할 코드 블록
            System.out.println("홀수");
        }

        number = 0;
        if (number > 0) { // (1)
            System.out.println("양수");
        } else if (number < 0) { // (2)
            System.out.println("음수");
        } else { // (3)
            System.out.println("zero");
        }
        
        System.out.println("=== 프로그램 끝 ===");
    }

}
