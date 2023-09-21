package com.itwill.inheritance02;

public class SubClass extends SuperClass {

    // 클래스에서 생성자를 1개도 작성하지 않은 경우
    // 자바 컴파일러 기본 생성자를 만들어 줌.
    // 하위 클래스 생성자에서는 명시적인 호출이 없는 경우 상위 클래스의 기본 생성자가 호출됨.
    // 이런 경우에 만약 상위 클래스에 기본 생성자가 없으면, 컴파일 에러가 발생.
    
    public SubClass() {
        super(0); //-> 아규먼트를 갖는 상위 클래스 생성자를 명시적으로 호출해야만 함.
    }
    
    public SubClass(int a) {
        super(a);
        // TODO
    }

}
