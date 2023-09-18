package com.itwill.class01;

public class AppMain01 {

    public static void main(String[] args) {
        // 클래스: 데이터 타입.
        // 생성자(constructor): 클래스에 선언된 변수(필드)들을 초기화(initialize).
        Subject sub1 = new Subject(); // 생성자 호출. 객체 생성. 인스턴스화.
        
        System.out.println(sub1.java);
        System.out.println(sub1.sql);
        System.out.println(sub1.js);
        
        sub1.java = 100;
        sub1.sql = 100;
        sub1.js = 50;
        System.out.println("java = " + sub1.java);

        Subject sub2 = new Subject(100, 50, 10);
        System.out.println(sub2.java);
        System.out.println(sub2.sql);
        System.out.println(sub2.js);
     
        // 함수형 프로그래밍(functional programming)
        int total = getTotal(sub1);
        System.out.println("sub1 total = " + total);
        System.out.println("sub2 total = " + getTotal(sub2));
        
        // 객체지향 프로그래밍(object-oriented programming)
        System.out.println("sub1 total = " + sub1.getTotal());
        System.out.println("sub1 mean = " + sub1.getMean());
        
        System.out.println("sub2 total = " + sub2.getTotal());
        System.out.println("sub2 mean = " + sub2.getMean());
    }

    // Subject 타입의 객체를 아규먼트로 전달받아서 세 과목의 총점을 반환하는 기능.
    public static int getTotal(Subject subject) {
        return subject.java + subject.sql + subject.js;
    }
    
}
