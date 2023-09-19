package com.itwill.modifier05;

import com.itwill.modifier06.PublicClass;
//import com.itwill.modifier06.PackageClass; //-> 컴파일 에러(not visible)

/*
 * 클래스 멤버의 접근(가시성) 수식어: private < (package) < protected < public
 * 클래스 접근(가시성) 수식어(access/visibility modifier):
 * 1. public: 어디서나 공개된 클래스. import 문장을 사용할 수 있음.
 * 2. (package): 수식어가 없는 경우. 같은 패키지의 클래스에서만 사용할 수 있는 클래스.
 * (주의) public class의 이름은 자바 파일의 이름과 같아야 함!
 * 하나의 자바 파일 안에서 클래스를 여러개 선언하는 것은 가능하지만,
 * public class는 파일에서 오직 한 개만 선언할 수 있음.
 * 한 개의 파일에서 클래스를 여러개 선언했을 때, 컴파일 후에는 각각의 클래스 파일(바이트 코드)이 생성됨.
 * 바이트 코드: 자바 가상 머신(JVM, Java Virtual Machine)이 실행할 수 있는 명령어 셋.
 */

class A {}

class B {}

public class ModifierMain05 {

    public static void main(String[] args) {
        PublicClass c = new PublicClass();
        System.out.println(c);

        //com.itwill.modifier06.PackageClass c2; //-> 컴파일 에러(not visible)
    }

}
