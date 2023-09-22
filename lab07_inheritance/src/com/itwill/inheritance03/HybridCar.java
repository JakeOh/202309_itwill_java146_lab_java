package com.itwill.inheritance03;

public class HybridCar extends Car {
    // 필드
    private int battery;

    public HybridCar(int fuel, int speed, int battery) {
        super(fuel, speed);
        this.battery = battery;
    }
    
}
