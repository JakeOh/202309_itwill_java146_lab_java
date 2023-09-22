package com.itwill.inheritance03;

public class HybridCar extends Car {
    // 필드
    private int battery;

    // 생성자
    public HybridCar(int fuel, int speed, int battery) {
        super(fuel, speed);
        this.battery = battery;
    }
    
    // 메서드/생성자 오버로딩(method overloading):
    // 파라미터(개수, 타입)가 다른 같은 이름의 메서드/생성자가 여러개 작성된 것.
    
    // 메서드 오버라이딩(method overriding), 재정의:
    // 상위 클래스에서 작성된 메서드를 하위 클래스에서 재정의하는 것.
    // 리턴 타입, 메서드 이름, 파라미터 선언은 모두 같아야 함.
    // 접근 수식어는 상위 클래스의 가시성 범위와 같거나 더 넓어질 수 있음.
    
    // Car 클래스의 drive 메서드를 재정의
    @Override //-> 애너테이션(annotation) - 컴파일러가 사용.
    public void drive() {
        // super.drive(); //-> 상위 객체의 재정의 전 메서드 호출 가능.
        
        System.out.println("speed:" + getSpeed() +"km/h, fuel:" + getFuel() 
                + "L, battery:" + battery + "%");
    }
    
    // override가 아니고, overloading.
    public void drive(int speed) {
        
    }
    
    public int charge(int battery) { // 충전
        this.battery = battery;
        return this.battery;
    }
    
}
