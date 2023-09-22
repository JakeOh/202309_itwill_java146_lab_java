package com.itwill.inheritance04;

/*
 * final: 변경할 수 없는.
 * final 지역 변수: 값을 초기화하면 그 값을 변경할 수 없는(재할당할 수 없는) 지역 변수.
 * final 필드: 반드시 한 번은 (명시적으로) 초기화해야 하고, 초기화 이후에는 값을 변경할 수 없는 필드.
 *   (1) final 필드를 선언과 동시에 초기화.
 *   (2) final 필드를 초기화할 수 있는, 아규먼트를 갖는 생성자를 작성.
 * final 메서드: 변경할 수 없는 메서드. 재정의(override)할 수 없는 메서드.
 * final 클래스: 변경할 수 없는 클래스. 상속받을 수 없는(확장할 수 없는) 클래스.
 *   (예) java.lang.System, java.lang.String, ...
 * 
 */

//class SubSystem extends System {} //-> 컴파일 에러.

final class Super {}
//class Sub extends Super {} //-> 컴파일 에러: 상속받을 수 없음.

class A {
    public void test1() {
        System.out.println("test1");
    }
    public final void test2() {
        System.out.println("test2");
    }
}

class B extends A {
    @Override //-> final이 아닌 메서드는 하위 클래스에서 재정의할 수 있음.
    public void test1() {
        System.out.println("override test1");
    }
    
//    @Override //-> 상위 타입의 final 메서드는 재정의할 수 없음.
//    public void test2() {}
    
}

public class InheritanceMain04 {

    public static final int MAX = 100; // final 필드 초기화 (1)
    
    private final int n;
    public InheritanceMain04(int n) {
        this.n = n; // final 필드 초기화 (2)
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
