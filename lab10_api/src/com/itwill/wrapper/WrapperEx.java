package com.itwill.wrapper;

/*
 * Wrapper 클래스: 자바의 기본 데이터 타입의 값을 하나만 저장하는(감싸는, 포장하는) 클래스.
 * 기본 데이터 타입: boolean, byte, short, int, long, char, float, double
 * wrapper 클래스: Boolean, Byte, Short, Integer, Long, Character, Float, Double
 * - java.lang 패키지에 있기 때문에, import 문장 없이 사용 가능.
 * - 목적:
 *   (1) 기본 데이터 타입의 데이터를 이용하는 메서드를 제공.
 *   (2) 상속/다형성을 이용하기 위해서. 
 *   (3) generic 클래스(List, Set, Map)를 이용하기 위해서.
 */

public class WrapperEx {

    public static void main(String[] args) {
        // Integer 타입 객체 생성: int 값을 받아서 Integer 객체로 생성.
        Integer number1 = Integer.valueOf(1);
        System.out.println(number1);
        
        Integer number2 = Integer.valueOf("100"); // String 값을 받아서 Integer 객체로 생성.
        System.out.println(number2);
        
        int x = Integer.parseInt("123"); // String 값을 int 값으로 변환.
        System.out.println(x);
        
        // auto-boxing: int 값을 자동으로 Integer 타입 객체로 생성.
        Integer number3 = 3;
        System.out.println(number3);
        
        // auto-unboxing: Integer 타입 객체에서 int 값을 자동으로 추출.
        int subtract = number1 - number3;
        System.out.println(subtract);

    }

}
