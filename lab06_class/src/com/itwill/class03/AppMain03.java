package com.itwill.class03;

public class AppMain03 {

    public static void main(String[] args) {
        // 객체 생성, 초기화, 메서드 호출 연습
        Circle c1 = new Circle();
        System.out.println("c1 = " + c1);
        System.out.println("c1 넓이 = " + c1.area());
        System.out.println("c1 둘레 = " + c1.perimeter());
        
        Circle c2 = new Circle(1.0);
        System.out.println("c2 = " + c2);
        System.out.println("c2 넓이 = " + c2.area());
        System.out.println("c2 둘레 = " + c2.perimeter());
        
    }

}
