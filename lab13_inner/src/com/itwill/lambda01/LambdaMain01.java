package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

public class LambdaMain01 {

    public static void main(String[] args) {
        // Calculator 타입의 객체 생성
        Calculator calc = new Calculator(1, 2);
        
        // Calculable 인터페이스를 구현하는 Adder 타입 객체를 생성
        Calculable adder = new Adder();
        // 생성된 객체를 calculate 메서드의 아규먼트로 전달.
        double result = calc.calculate(adder);
        System.out.println("result = " + result);

    }

}
