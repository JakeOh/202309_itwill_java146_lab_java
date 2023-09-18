package com.itwill.class02;

public class AppMain02 {

    public static void main(String[] args) {
        // Rectangle 타입의 변수 선언, 초기화(객체 생성).
        Rectangle rect1 = new Rectangle();
        System.out.println(rect1);
        System.out.println("rect1 width = " + rect1.width);
        System.out.println("rect1 height = " + rect1.height);
        
        // 객체의 필드(속성) 값들을 변경
        rect1.width = 2.0;
        rect1.height = 3.0;
        
        // 객체의 메서드(기능) 호출(사용)
        System.out.println("rect1 넓이 = " + rect1.area());
        System.out.println("rect1 둘레 = " + rect1.perimeter());

        // 아규먼트를 갖는 생성자를 사용해서 객체 생성.
        Rectangle rect2 = new Rectangle(3.0, 4.0);
        System.out.println(rect2);
        System.out.println("rect2 width = " + rect2.width);
        System.out.println("rect2 height = " + rect2.height);
        
        System.out.println("rect2 넓이 = " + rect2.area());
        System.out.println("rect2 둘레 = " + rect2.perimeter());
        
    }

}
