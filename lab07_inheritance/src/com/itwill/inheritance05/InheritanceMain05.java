package com.itwill.inheritance05;

import java.util.Random;
import java.util.Scanner;

class T {}

public class InheritanceMain05 {

    public static void main(String[] args) {
        // java.lang.Object 클래스: 자바의 최상위 클래스.
        // 자바의 모든 클래스는 Object를 상속(확장) 
        // -> Object 클래스의 메서드들을 하위 타입 객체에서 사용할 수 있음.
        // -> Object 클래스의 메서드들을 하위 클래스에서 재정의(override)할 수 있음.
        // -> toString(), equals(), hashCode(), ...

        T t = new T();
        System.out.println(t.getClass()); // 클래스 타입을 리턴
        int hash = t.hashCode(); // 해시코드를 리턴
        System.out.println(hash + " = " + Integer.toHexString(hash));
        System.out.println(t.toString());
        System.out.println(t);
        //-> System.out.println(Object o) 메서드는 객체의 문자열 표현식을 콘솔에 출력.
        //-> println 메서드는 객체가 가지고 있는 toString()의 리턴값을 출력.
        
        Random rand = new Random();
        System.out.println(rand);
        //-> Random 클래스는 toString 메서드를 재정의(override)하지 않았음.
        
        Scanner sc = new Scanner(System.in);
        System.out.println(sc);
        //-> Scanner 클래스는 toString 메서드를 재정의(override)하고 있음.
        
        T t2 = new T();
        System.out.println(t.equals(t2)); // 두 객체가 같은 지를 리턴.
        T t3 = t;
        System.out.println(t.equals(t3));
        
        // equals 메서드가 재정의(override)된 예
        String s1 = new String("Java");
        String s2 = new String("Java");
        System.out.println(s1 == s2);
        //-> 비교 연산자(==)는 참조변수에 저장된 객체의 참조값을 비교.
        System.out.println(s1.equals(s2));
        //-> String 클래스에서 equals 메서드는 문자열의 내용이 같으면 
        // (실제로 생성된 문자열 객체가 다르더라도) true를 리턴하도록 재정의(override) 되어 있음.
        //-> 두 문자열이 같은 지를 비교할 때는 반드시 equals 메서드를 사용해야 함!
    }

}
