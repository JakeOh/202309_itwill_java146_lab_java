package com.itwill.exception03;

import java.util.Scanner;

public class ExceptionMain03 {
    
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // ExceptionMain03 타입의 객체 생성
        ExceptionMain03 app = new ExceptionMain03();
        
        int x = app.inputInteger2();
        System.out.println("x = " + x);

    }
    
    public int inputInteger() {
        int result = 0;
        while (true) {
            try {
                System.out.print("정수 입력> ");
                result = Integer.parseInt(sc.nextLine());
                break; // 무한 반복문 종료
            } catch (NumberFormatException e) {
                System.out.println("입력한 값은 정수가 아닙니다.");
            }
        }
        
        return result;
    }
    
    public int inputInteger2() {
        try {
            System.out.print("정수 입력> ");
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("입력한 값은 정수가 아닙니다.");
            return inputInteger2();
        }
        
    }

}
