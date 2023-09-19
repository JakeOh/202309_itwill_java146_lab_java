package com.itwill.modifier03;

public class Person {
    // 필드
    private String name; // 읽기(get) 전용 데이터
    private int age; // 읽기, 쓰기(set) 가능 데이터
    
    // 생성자
    public Person(String name, int age) {
        this.name = name;
        if (age >= 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    // 메서드
    // 이름(name)을 리턴하는 메서드 - getter
    public String getName() {
        return this.name;
    }
    
    // 나이(age)를 리턴하는 메서드 - getter
    public int getAge() {
        return this.age;
    }
    
    // 나이(age)를 수정하는 메서드 - setter
    public void setAge(int age) {
        // 나이는 0 이상이어야 한다는 무결성을 유지하기 위해서
        if (age >= 0) {
            this.age = age;
        }
        // age < 0 인 경우에는 값을 변경하지 않음.
    }
    
}
