package com.itwill.variable04;

public class VariableMain04 {

    public static void main(String[] args) {
        // 자바 기본 데이터 타입:
        //byte a = 128;  //-> byte 타입의 정수는 -128 ~ 127 범위의 정수만 저장 가능.
        //short b = -32_769;  //-> short 타입의 정수는 -32,768 ~ 32,767 범위의 정수만 저장 가능.
        //int c = 10_000_000_000;
        long d = 10_000_000_000L;
        //-> 숫자 상수(literal)가 int 범위를 넘을 때는 숫자 뒤에 L을 붙여줘야 함.
        // 이유는 자바에서 정수의 기본 타입은 int이기 때문에.
        
        // 자바에서 실수의 기본 타입은 double!
        double x = 1.0; //-> double 타입 정수 상수(literal)를 만듦.
        float y = 1.0f; //-> float 타입 정수 상수(literal)를 만듦.
        
    }

}
