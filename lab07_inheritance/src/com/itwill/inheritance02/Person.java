package com.itwill.inheritance02;

// 학생은 사람이다. 학생은 사람을 확장(상속)한다.
// 사람-superclass, 학생-subclass
public class Person {
    // 필드
    private String name;
    
    // 생성자
    // (1) 기본 생성자
    public Person() {
        System.out.println("Person() 호출");
    }
    
    // (2) 아규먼트를 갖는 생성자
    public Person(String name) {
        this.name = name;
        System.out.println("Person(name) 호출");
    }
    
    // getter, setter 메서드
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
