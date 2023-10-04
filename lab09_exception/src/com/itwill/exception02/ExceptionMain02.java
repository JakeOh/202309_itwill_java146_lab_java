package com.itwill.exception02;

import java.util.Scanner;

/*
 * try-catch 문장을 사용한 예외 처리:
 * 
 * try {
 *     정상적인 상황에서 실행할 코드(블록); // (1)
 * } catch (Exception 타입 변수 선언) {
 *     예외가 발생했을 때 실행할 코드(블록); // (2)
 * } finally {
 *     예외 발생 여부와 상관없이 반드시 실행할 코드(블록); // (3)
 * }
 * 
 * 예외가 발생하지 않을 경우: (1) --> (3)
 * 예외가 발생하는 경우: (1) --> 예외 발생 --> (2) --> (3)
 * 
 * try-catch 문장에서 catch 블록은 1개 이상이 있어야 함.
 * finally 블록은 선택.
 * catch 블록은 처리하려고 하는 예외 종류에 따라서 여러개를 작성할 수 있음.
 * catch 블록이 여러개일 때는 하위 타입의 예외들을 먼저 catch하고,
 * 상위 타입의 예외들을 나중에 catch해야 함.
 */

public class ExceptionMain02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("x = ");
            int x = Integer.parseInt(sc.nextLine());
            
            System.out.print("y = ");
            int y = Integer.parseInt(sc.nextLine());
            
            int result = x / y;
            System.out.println("몫 = " + result);
        } catch (ArithmeticException e) {
            System.out.println("y는 0이 될 수 없음.");
        } catch (NumberFormatException e) {
            System.out.println("x와 y는 정수로만 입력해야 함.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally...");
        }

    }

}
