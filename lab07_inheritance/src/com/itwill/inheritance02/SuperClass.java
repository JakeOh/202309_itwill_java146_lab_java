package com.itwill.inheritance02;

public class SuperClass {
    private int a;

//    public SuperClass() {
//        this(0);
//    }
    
    public SuperClass(int a) {
//        this(); //-> overloading된 생성자들 중에서 기본 생성자 호출
        this.a = a; //-> this 의미: SuperClass 타입으로 생성된 객체 (주소)
    }
}
