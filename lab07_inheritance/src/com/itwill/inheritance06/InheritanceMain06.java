package com.itwill.inheritance06;

public class InheritanceMain06 {

    public static void main(String[] args) {
        // Point 타입 객체 생성
        Point p1 = new Point();
        System.out.println(p1); // toString 재정의
        
        Point p2 = new Point(0.0, 0.0);
        System.out.println(p2);
        
        System.out.println(p1.equals(p2)); // equals 재정의
        
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

    }

}
