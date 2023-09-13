package com.itwill.loop14;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        // Scanner 타입을 사용한 입력 받기:
        
        Scanner sc = new Scanner(System.in);
        
        // nextInt(): 입력 버퍼(임시 메모리)에서 토큰(공백, 탭, 엔터)으로 구분된 입력값을 
        // 읽어서 정수(int)를 반환.
        // nextDouble(): 입력버퍼(임시 메모리)에서 토큰(공백, 탭, 엔터)으로 구분된 입력값을
        // 읽어서 실수(double)를 반환.
        // next(): 입력버퍼(임시 메모리)에서 토큰(공백, 탭, 엔터)으로 구분된 입력값을
        // 읽어서 문자열(String)을 반환.
        // nextInt(), nextDouble(), next(): 값을 읽은 후에도 입력 버퍼에 남아있는 내용이 있을 수 있음.
        
        System.out.print("정수 입력>>> ");
        int n1 = sc.nextInt();
        System.out.println("n1 = " + n1);
        
        System.out.print("정수 입력>>> ");
        int n2 = sc.nextInt();
        System.out.println("n2 = " + n2);
        
        System.out.print("문자열 입력>>> ");
        String s = sc.next();
        System.out.println("s = " + s);
        
        System.out.println("정수 입력>>> ");
        int n3 = sc.nextInt();
        System.out.println("n3 = " + n3);

        sc.nextLine(); // 입력 버퍼에 남아있는 모든 내용을 읽고 지움.
        
        // nextLine(): 입력 버퍼에서 엔터를 만날 때까지 모든 값을 읽어서 "문자열"을 리턴.
        // -> nextLine() 호출한 이후에는 입력 버퍼의 모든 내용이 지워짐.
        System.out.print("문자열 입력>>> ");
        String msg = sc.nextLine();
        System.out.println("msg = " + msg);
        
        System.out.print("실수 입력>>> ");
        double n4 = sc.nextDouble();
        System.out.println("n4 = " + n4);
    }

}










