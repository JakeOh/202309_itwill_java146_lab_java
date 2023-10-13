package com.itwill.lambda01;

public class Calculator {
    // 중첩 인터페이스(static은 생략 가능)
    // 함수형 인터페이스(functional interface): 추상 메서드를 오직 1개만 갖는 인터페이스.
    @FunctionalInterface
    public interface Calculable {
        double calculate(double x, double y);
    }
    
    // 필드
    private double x;
    private double y;
    
    // 생성자
    public Calculator(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // 메서드
    public double calculate(Calculable calc) {
        return calc.calculate(x, y);
    }

}
