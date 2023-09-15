package com.itwill.class01;

public class AppMain01 {

    public static void main(String[] args) {
        // 클래스: 데이터 타입.
        // 생성자(constructor): 클래스에 선언된 변수(필드)들을 초기화.
        Subject subject = new Subject();
        
        System.out.println(subject.java);
        System.out.println(subject.sql);
        System.out.println(subject.js);
        
        subject.java = 100;
        subject.sql = 100;
        subject.js = 50;
        

    }

}
