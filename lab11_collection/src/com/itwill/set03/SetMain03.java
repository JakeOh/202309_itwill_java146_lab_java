package com.itwill.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {
        // 정수를 저장하는 HashSet을 선언, 객체 생성.
        HashSet<Integer> numbers = new HashSet<>();
        
        Random random = new Random();
        
        // [0, 10) 범위의 서로 다른 정수 난수 5개를 set에 저장.
//        int count = 0;
        while (numbers.size() < 5) {
//            count++;
            int x = random.nextInt(10);
            System.out.println("x = " + x);
            
            numbers.add(x);
            System.out.println("numbers = " + numbers);
        }
        
        // 그 결과를 출력.

    }

}
