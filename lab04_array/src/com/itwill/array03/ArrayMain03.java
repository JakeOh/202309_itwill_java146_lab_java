package com.itwill.array03;

import java.util.Random;

public class ArrayMain03 {

    public static void main(String[] args) {
        // 향상된 for 구문은 배열에 저장된 값들을 순서대로 읽는 경우에만 사용.
        // (주의) 향상된 for 구문은 배열의 원소를 저장/변경할 때 이용할 수 없음.
        // 배열의 원소를 저장/변경할 때는 반드시 "배열[인덱스] = 값;" 문장을 사용해야만 함. 
        
        Random random = new Random();
        
        int[] numbers = new int[3]; // 정수(int) 3개를 저장할 수 있는 배열.
        for (int x : numbers) {
            x = 10; // numbers의 원소가 변경되는 것이 아니라, 지역변수 x의 값만 변경.
        }
        
        for (int x : numbers) {
            System.out.print(x + " ");  //-> 0을 출력
        }
        System.out.println();
        
        // Ex. 
        // (1) 정수(int) 10개를 저장할 수 있는 배열을 만들고,
        // (2) 1 이상 4 이하(5 미만)의 정수들을 임의로 저장하고 
        // (3) 그 내용을 출력.
        // (4) 문자열 10개를 저장할 수 있는 배열을 만들고,
        // (5) (1)에서 만들 배열의 원소가 1 또는 3이면 "남성"을 저장, 2 또는 4이면 "여성"을 저장.
        // (6) 문자열 배열 내용을 출력.
        
        int len = 10; // 배열의 길이(원소 개수)로 사용할 변수.
        
        int[] codes = new int[len]; // (1)
        
        // (2)
        for (int i = 0; i < len; i++) {
            codes[i] = random.nextInt(1, 5);
        }
        
        // (3)
        for (int x : codes) {
            System.out.print(x + "\t");
        }
        
        // (4)
        String[] genders = new String[len];
        
        // (5)
        for (int i = 0; i < len; i++) {
            if (codes[i] == 1 || codes[i] == 3) {
                genders[i] = "남성";
            } else {
                genders[i] = "여성";
            }
        }
        System.out.println();
        
        // (6)
        for (String s : genders) {
            System.out.print(s + "\t");
        }
        System.out.println();
        
    }

}
