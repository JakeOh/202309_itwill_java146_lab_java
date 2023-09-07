package com.itwill.print; // 패키지 선언문

public class PrintMain {

    // 메인 메서드 - 프로그램 시작.
    public static void main(String[] args) {
        System.out.println("한 줄 출력"); // print line
        System.out.println("1 + 2");
        System.out.println(1 + 2);
        System.out.println("1 + 2 = 3");
        System.out.println("1 + 2 = " + (1 + 2)); //-> 1 + 2 = 3
        System.out.println("1 + 2 = " + 1 + 2);   //-> 1 + 2 = 12
        
        System.out.print("Hello");
        System.out.print("안녕");
        
        System.out.println("Java");
        
        System.out.printf("문자열 포맷: %d, %f, %s\n", 100, 3.14, "hello");
        // %d: digit. 정수 출력.
        // %f: floating-point number. 실수 출력.
        // %s: string. 문자열 출력.
        // \n: new line. 줄바꿈.
        
        System.out.printf("%d + %d = %d\n", 1, 2, (1 + 2));
    }
    
}
