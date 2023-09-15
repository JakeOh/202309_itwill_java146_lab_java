package com.itwill.method06;

import java.util.Random;

public class MethodMain06 {

    public static void main(String[] args) {
        // 메서드 작성 연습:
        
        Random random = new Random();
        
        int genderCode = random.nextInt(5); // [0, 5) 범위의 정수 난수를 저장.
        System.out.println("genderCode = " + genderCode);
        
        // parseGenderCode()는 아규먼트가 1 또는 3이면 "male" 리턴,
        // 2 또는 4 이면 "female" 리턴, 그 이외의 숫자인 경우에는 "unknown" 리턴.
        String gender = parseGenderCode(genderCode);
        System.out.println("gender = " + gender);

    }

}
