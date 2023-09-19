package com.itwill.modifier01;

/*
 * 클래스 멤버(필드, 생성자, 메서드)의 접근(가시성) 수식어(access modifier):
 * - 클래스의 멤버들을 보여주는 범위를 설정.
 * - 가시성의 범위: private < (package) < protected < public
 * 1. private: 선언된 클래스 안에서만 보이는(직접 접근 가능한) 멤버.
 * 2. (package): 수식어가 없는 경우. 같은 패키지에 있는 클래스에서 보이는(사용 가능한) 멤버.
 * 3. protected: 같은 패키지에 있거나 또는 상속하는 클래스에서 보이는(사용 가능한) 멤버.
 * 4. public: 어디서든 보이는(사용 가능한) 멤버.
 */

public class ModifierMain01 {

    public static void main(String[] args) {
        // AccessTest 타입의 객체 생성
        AccessTest test = new AccessTest(1, 2, 3, 4);
//        System.out.println(test.a); //-> 컴파일 에러: 보이지 않음(not visible)
        System.out.println(test.b);
        test.b = 100;
        test.info();

    }

}
