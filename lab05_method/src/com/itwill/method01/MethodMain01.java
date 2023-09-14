package com.itwill.method01;

import java.util.Random;

/*
메서드(method): 클래스 안에서 작성하는 함수(function, 기능).
  - 프로그램에서 반복적으로 사용되는 기능을 코드 블록으로 작성.
  - 자바는 클래스 안에서만 함수를 작성할 수 있음. 클래스 바깥에서는 함수를 작성할 수 없음!
  - 자바는 메서드만 작성할 수 있음.
  
argument: 인수. 메서드를 호출하는 곳에서 메서드에게 전달하는 값.
parameter: 매개변수. 인자. 아규먼트를 저장하기 위해서 메서드를 선언(정의)하는 곳에서 선언하는 지역 변수.
return value: 반환 값. 메서드가 기능을 모두 수행한 후에 메서드를 호출한 곳으로 반환하는 값.
  - 메서드에 따라서 반환 값이 있을 수도 있고, 없을 수도 있음. 

메서드 선언(정의)하는 방법:
[수식어] 리턴타입 메서드이름([파라미터 선언, 파라미터 선언, ...]) { ... }
  - void: 메서드가 반환하는 값이 없을 때 사용하는 반환 타입.
*/

public class MethodMain01 {

    public static void main(String[] args) {
        Random random = new Random(); // 난수를 만들기 위한 변수
        
        // nextInt(x) : [0, x) 범위의 정수 난수 1개를 반환하는 기능(메서드).
        int n1 = random.nextInt(10); // [0, 10) 난수
        System.out.println("n1 = " + n1);
        
        int n2 = random.nextInt(100); // [0, 100) 난수
        System.out.println("n2 = " + n2);

        // nextInt(x, y): [x, y) 범위의 정수 난수 1개를 반환하는 기능(메서드).
        int n3 = random.nextInt(50, 60); // [50, 60) 난수
        System.out.println("n3 = " + n3);
        
    }

}
