package com.itwill.class03;

// 클래스: 데이터,속성(필드) + 초기화(생성자) + 기능(메서드) => 데이터 타입.
public class Circle {
    // 필드(field)
    double radius; // 원의 반지름
    
    // 생성자
    // 기본 생성자
    public Circle() {}
    
    // 아규먼트를 갖는 생성자
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // 메서드
    // area: 원의 넓이 리턴. 3.14 * 반지름 * 반지름.
    public double area() {
        return 3.14 * radius * radius;
    }
    
    // perimeter: 원의 둘레 길이 리턴. 2 * 3.14 * 반지름.
    public double perimeter() {
        return 2 * 3.14 * radius;
    }
    
}
