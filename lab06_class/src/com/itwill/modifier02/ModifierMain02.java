package com.itwill.modifier02;

import com.itwill.modifier01.AccessTest;
// 다른 패키지에서 선언된 클래스 이름으로 변수를 선언하거나 사용하려고 할 때
// (1) import 문장을 작성하고, 클래스 이름만 사용.
// (2) 패키지 이름을 포함한 클래스 전체 이름을 사용할 수도 있음 -> import 문장이 필요 없음.
// java.lang 패키지에 포함된 클래스들은 import 문장 없이 클래스 이름을 사용할 수 있음!
//   (예) java.lang.String, java.lang.System, java.lang.Math, ...

public class ModifierMain02 {

    public static void main(String[] args) {
        // AccessTest 타입 객체 생성
        AccessTest test = new AccessTest(1, 2, 3, 4); // (1) import + 클래스 이름
//        System.out.println(test.c); //-> 컴파일 에러(not visible)
//        test.c = 100;
        test.d = 100; // 다른 패키지에 있는 클래스에서는 public으로 공개된 멤버만 사용 가능.
        test.info();
        
        com.itwill.modifier01.AccessTest test2 =
                new com.itwill.modifier01.AccessTest(0, 0, 0, 0);
        test2.info();
                
    }

}
