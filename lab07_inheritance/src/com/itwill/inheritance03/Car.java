package com.itwill.inheritance03;

// 하이브리드 자동차는 자동차이다.
// 자동차 - 상위 클래스, 하이브리드 자동차 - 하위 클래스
public class Car {
    // 필드
    private int fuel; // 연료
    private int speed; // 속력
    
    // 생성자
    public Car(int fuel, int speed) {
        this.fuel = fuel;
        this.speed = speed;
    }
    
    // 메서드
    public int getFuel() {
        return this.fuel;
    }
    
    public int getSpeed() {
        return this.speed;
    }
    
    public void drive() {
        System.out.println("speed: " + speed + ", fuel: " + fuel);
    }

}
