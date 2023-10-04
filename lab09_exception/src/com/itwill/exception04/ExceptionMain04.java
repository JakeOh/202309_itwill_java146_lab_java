package com.itwill.exception04;

public class ExceptionMain04 {

    public static void main(String[] args) {
        // finally 블록: 예외 발생 여부와 상관없이 항상 실행되는 블록.
        // try 또는 catch 블록에 return 문장이 있어도, finally 블록이 실행된 후에 return이 실행됨.
        
        try {
            int x = 100;
            int y = 0;
            System.out.println("몫 = " + (x / y));
            System.out.println("end try");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("end catch");
            
            return; // main 메서드 종료
        } finally {
            System.out.println("언제 출력될까요?");
        }
        
        System.out.println("end main");
        //return;
    } // end main

}
