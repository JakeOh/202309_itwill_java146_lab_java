package com.itwill.exception06;

/*
 * 예외 클래스들의 상속 관계:
 * Object
 * |__ Throwable
 *     |__ Exception
 *         |__ RuntimeException, IOException, ...
 *             |__ ArtithmeticException, NullPointerException, NumberFormatException, ...
 * throws 선언문이 있는 메서드들 중에서 RuntimeException과 그 하위 예외 클래스들을 던지는(throw)
 * 메서드들은 try-catch를 사용하지 않아도 컴파일 가능.
 * RuntimeException이 아닌 예외를 던진다고 선언한 메서드들은 반드시 try-catch를 사용해야 함.
 * 
 */

public class ExceptionMain06 {

    public static void main(String[] args) {
        // Calculator 타입 객체 생성
        Calculator calc = new Calculator();
        
        // Calculator 타입 객체의 메서드 호출
        try {
            int result = calc.divide(100, 0);
            System.out.println("몫=" + result);
        } catch (Exception e) {
            e.printStackTrace();
            //-> 예외 이름, 메시지, 예외 위치를 콘솔에 출력.
        }

    }

}
