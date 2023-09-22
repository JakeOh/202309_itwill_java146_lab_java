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

        //car3.charge(); //-> 컴파일 에러
        // 실제 생성된 객체는 HybridCar 타입이지만, Car 타입으로 선언했기 때문에
        // Car 타입의 메서드들만 사용 가능.
        
        ((HybridCar) car3).charge(100);
//        HybridCar hcar = (HybridCar) car3;
        // 실제 생성된 객체는 HybridCar 타입이기 때문에, 타입변환(casting)이 가능.
        // 타입 변환 후에는 HybridCar 타입의 모든 메서드들을 사용할 수 있게 됨.
        
    }

}
