package com.itwill.singleton;

// singleton(싱글톤): 오직 한 번만 생성할 수 있는 객체.

public class SingletonMain {

    public static void main(String[] args) {
        // Captain 타입 객체 생성
        Captain captain1 = Captain.getInstance();
        System.out.println("captain1: " + captain1);
        System.out.println(captain1.getName());
        
        Captain captain2 = Captain.getInstance();
        System.out.println("captain2: " + captain2);
        System.out.println(captain2.getName());

        captain2.setName("아이언맨");
        System.out.println(captain1.getName());
        System.out.println(captain2.getName());
        
    }

}
