package com.itwill.loop01;

public class LoopMain01 {

    public static void main(String[] args) {
        // 반복문
        System.out.println("Java 1");
        System.out.println("Java 2");
        System.out.println("Java 3");
        System.out.println("Java 4");
        System.out.println("Java 5");
        
        System.out.println("==========");
        
        // for (초기화 문장; 반복 조건식; 증가/감소) { 반복한 실행 코드 블록; }
        for (int i = 1; i <= 5; i++) {
            System.out.println("Java " + i);
        }
        
        // 증가 연산자(++), 감소 연산자(--):
        // 단항 연산자. 변수 이름 앞 또는 뒤에서 사용. (예) ++i, i++
        // 변수의 값을 1 증가/감소.
        // int x = 1;
        // x = x + 1;
        // x += 1; -> 복합 할당 연산자: +=, -=, *=, /=, %=, ...
        // x++;

        System.out.println("==========");
        // countdown: 5, 4, 3, 2, 1 순서로 출력.
        for (int n = 5; n > 0; n--) {
            System.out.println(n);
        }
        
    }

}
