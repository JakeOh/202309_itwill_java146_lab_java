package com.itwill.class02;

// 클래스: 데이터(필드) + 초기화(생성자) + 기능(메서드) => 데이터 타딥
public class Rectangle {

    // 필드(field)
    double width; // 직사각형의 가로 길이
    double height; // 직사각형의 세로 길이
    
    // 생성자
    // 기본 생성자(default constructor)
    public Rectangle() {}
    
    // 아규먼트를 갖는 생성자
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        // 필드의 이름과 지역변수(파라미터)의 이름이 같은 경우, 구분하기 위해서 필드는 this를 사용. 
    }
    
    // 메서드
    // 직사각형의 넓이를 리턴하는 메서드
    public double area() {
        return width * height;
        // 필드와 지역 변수 이름이 같지 않은 경우에는 필드 앞에 this를 생략해도 됨.
    }
    
    // 직사각형의 둘레의 길이를 리턴하는 메서드
    public double perimeter() {
        return (width + height) * 2;
    }
    
}
