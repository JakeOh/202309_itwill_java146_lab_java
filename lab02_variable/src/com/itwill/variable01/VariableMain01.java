package com.itwill.variable01;

public class VariableMain01 {

    public static void main(String[] args) {
        // 변수(variable): 프로그램에서 필요한 데이터를 저장하는 메모리 공간.
        // 1. 변수 선언: 변수의 데이터 타입과 이름을 선언.
        // 타입 이름;
        int age; // 정수를 저장하는 변수 age 선언.
        
        // 2. 변수 초기화: 변수에 값을 처음으로 저장.
        // 변수 = 값;
        age = 16;
        
        System.out.println("나이: " + age);
        
        // 변수 선언과 초기화를 한 문장으로 작성:
        int x = 100;
        System.out.println("x = " + x);

        // 자바의 기본 데이터 타입:
        // 정수 타입: byte, short, int, long, char
        // 실수 타입: float, double
        // 논리 타입: boolean
        
    }

}
