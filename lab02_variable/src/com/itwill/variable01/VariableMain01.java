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
        
        // 변수 이름 작성 규칙:
        // - 변수 이름은 알파벳, 숫자, _, $만 사용 가능.
        // - 변수 이름은 대/소문자를 구분함.
        // - 변수 이름은 숫자로 시작할 수 없음.
        // - 변수 이름으로 자바의 키워드(예약어)는 사용할 수 없음.
        // - 변수 이름은 변수의 역할에 어울리는 "의미 있는" 단어를 사용해서 만드는 것을 권장.
        // - 변수 이름을 2개 이상의 단어를 붙여서 만들 경우에는, 
        // 소문자로 시작하는 camel 표기법을 권장. (예) age, name, userId, userPassword, ...  
        
    }

}
