package com.itwill.exception05;

/*
 * multi-catch 블록 - Java 7 버전부터.
 * 하나의 catch 구문에서 여러개의 Exception 클래스를 선언하고 예외를 처리.
 * try {
 *     ...;
 * } catch (Exception1 | Exception2 | ... 변수) {
 *     ...;
 * }
 * 
 * (주의) multi-catch 블록에서는 상속 관계가 있는 예외 클래스들을 함께 사용할 수 없음!
 * 가능한 예: catch (ArithmeticException | NumberFormatException e)
 * 컴파일 에러: catch (ArithmeticException | Exception e)
 */

public class ExceptionMain05 {

    public static void main(String[] args) {
         
        try {
            int x = 100;
            int y = 7;
            System.out.println("몫 = " + (x / y));
            
            int[] array = new int[0]; // 정수(int) 0개를 저장하는 배열.
            array[0] = 123;
            System.out.println(array[0]);
             
         } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
             System.out.println("message: " + e.getMessage());
         }

    }

}
