package com.itwill.inheritance03;

public class InheritanceMain03 {

    public static void main(String[] args) {
        // Car 타입 객체 생성.
        Car car1 = new Car(50, 30);
        car1.drive();
        if (car1 instanceof HybridCar) {
            ((HybridCar) car1).charge(0);
        }
        
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
        
        // 다형성 장점: 다형성을 사용하면 코드의 재사용성(reuse)을 높여줌.
        // (예) 배열, 리스트 선언. 메서드 파라미터.
        HybridCar[] hcars = new HybridCar[5];
        //hcars[0] = new Car(0, 0);
        //-> 하위 타입 배열로 선언된 배열에는 상위 타입 객체를 저장할 수 없음.
        
        Car[] cars = new Car[5];
        cars[0] = new Car(0, 0);
        cars[1] = new HybridCar(0, 0, 0);
        
        // 다형성을 사용해서 파라미터가 선언된 메서드 예
        // System.out.println(Object o)
        System.out.println(new Car(0, 0));
        System.out.println(new HybridCar(0, 0, 0));
        
        // 다형성을 사용한 메서드 호출:
        test(new Car(0, 0));
        test(new HybridCar(0, 0, 0));
        
    } // end main
    
    // 아규먼트로 Car 타입 객체도 전달할 수 있고, 그 하위 타입인 HybridCar 객체도 전달할 수 있음.
    public static void test(Car c) {
        // instanceof 연산자: 객체가 어떤 타입인 지를 알려주는 연산자.
        if (c instanceof HybridCar) {
            System.out.println("하이브리드 자동차 테스트...");
        } else if (c instanceof Car) {
            System.out.println("일반 자동차 테스트...");
        } else {
            System.out.println("자동차가 아님...");
        }
    }

}
