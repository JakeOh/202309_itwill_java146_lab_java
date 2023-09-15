package com.itwill.class01;

public class AppMain01 {

    public static void main(String[] args) {
        // 클래스: 데이터 타입.
        // 생성자(constructor): 클래스에 선언된 변수(필드)들을 초기화(initialize).
        Subject subject = new Subject(); // 생성자 호출. 객체 생성. 인스턴스화.
        
        System.out.println(subject.java);
        System.out.println(subject.sql);
        System.out.println(subject.js);
        
        subject.java = 100;
        subject.sql = 100;
        subject.js = 50;
        System.out.println("java = " + subject.java);

        Subject sub2 = new Subject(100, 50, 10);
        System.out.println(sub2.java);
        System.out.println(sub2.sql);
        System.out.println(sub2.js);
        
    }

}
