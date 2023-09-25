package com.itwill.interface03;

class A {}
class B {}
class C extends A {} // 단일 상속

// 자바는 다중 상속을 허용하지 않음. 2개 이상의 클래스를 상속(extends)할 수 없음.
// class D extends A, B {}

interface E {}
interface F {}

// 자바 클래스에서 구현(implements)하는 인터페이스의 개수는 제한이 없음.
class G implements E, F {}

// 자바 인터페이스는 다른 인터페이스를 구현(implements)할 수 없음.
// interface H implements E {}

// 자바 인터페이스는 다른 인터페이스(들)을 상속(extends)할 수 있음. 다중 상속을 허용.
interface I extends E, F {}

interface Clickable {
    void click();
}
interface Scrollable {
    void scroll();
}
interface Button extends Clickable, Scrollable {}
class Clazz implements Button {
    @Override
    public void click() {}
    @Override
    public void scroll() {}
}

public class InterfaceMain03 {

    public static void main(String[] args) {
        
    }

}
