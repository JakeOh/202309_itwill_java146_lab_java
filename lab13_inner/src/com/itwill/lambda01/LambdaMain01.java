package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

public class LambdaMain01 {
    
    public static void main(String[] args) {
        // Calculator 타입의 객체 생성
        Calculator calc = new Calculator(1, 2);
    
        // 1. 외부 클래스(Adder) 선언 & 사용
        // Calculable 인터페이스를 구현하는 Adder 타입 객체를 생성
        Calculable adder = new Adder();
        // 생성된 객체를 calculate 메서드의 아규먼트로 전달.
        double result = calc.calculate(adder);
        System.out.println("result = " + result);
        
        // 2. 지역 클래스(Subtractor) 선언 & 사용
        class Subtractor implements Calculable {
            @Override
            public double calculate(double x, double y) {
                return x - y;
            }
        }
        // Subtractor 타입 객체를 calculate 메서드 아규먼트로 전달.
        result = calc.calculate(new Subtractor());
        System.out.println("result = " + result);
        
        // 3. 익명 클래스(anonymous class) 사용
        result = calc.calculate(new Calculable() {
            @Override
            public double calculate(double x, double y) {
                return x * y;
            }
        });
        System.out.println("result = " + result);
        
        // 4. 람다 표현식(Lambda expression) - 함수형 표기법
        result = calc.calculate((x, y) -> x / y);
        // result = calc.calculate((double x, double y) -> { return x / y; });
        System.out.println("result = " + result);
        
        /*
         * 람다 표현식:
         * 클래스 선언과 객체 생성을 동시에 하는 익명 클래스를 간단히 작성하기 위한 문법.
         * 함수형 인터페이스 타입 객체만 람다 표현식으로 작성할 수 있음.
         * 
         * 람다 표현식 문법: (파라미터 선언) -> { 메서드 코드; }
         * - 람다 표현식의 파라미터 선언에서는 변수 타입을 생략할 수 있음.
         * - 람다 표현식에서 메서드 본체의 문장이 하나만 있는 경우에는 {}와 ;을 생략할 수 있음.
         * - 람다 표현식에서 메서드 본체가 return 문장만 갖는 경우에는 {}, return, ;을 모두 생략하고, 리턴 값만 표기.
         *   (예) (x, y) -> x + y
         * - 람다 표현식에서 파라미터가 1개만 있는 경우에는 ()도 생략 가능.
         *   (예) x -> 2 * x + 3
         */

    } // end main

}
