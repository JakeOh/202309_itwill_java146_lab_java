package com.itwill.inheritance03;

public class InheritanceMain03 {

    public static void main(String[] args) {
        // Car 타입 객체 생성.
        Car car1 = new Car(50, 30);
        car1.drive();
        
        // HybridCar 타입 객체 생성.
        HybridCar car2 = new HybridCar(30, 50, 100);
        car2.drive();
        
        // 다형성(polymorphism)을 사용한 변수 선언과 초기화.
        // SuperType 변수 = new SubType();
        // SubType 변수 = new SuperType(); -> 컴파일 에러
        // HybridCar hcar = new Car(0, 0); -> 컴파일 에러
        
        Car car3 = new HybridCar(31, 51, 99);
        car3.drive();
        //-> 다형성으로 선언된 변수이더라도 재정의(override)된 메서드가 실행됨.

    }

}
