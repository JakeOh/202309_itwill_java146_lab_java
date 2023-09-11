package com.itwill.switch02;

import java.util.Random;

public class SwitchMain02 {

    public static void main(String[] args) {
        // Random 타입을 사용해서 genderCode에 5 미만의 정수를 저장:
        Random random = new Random();
        int genderCode = random.nextInt(5);
        System.out.println("genderCode = " + genderCode);
        
        // switch 구문을 사용해서
        // genderCode의 값이 1 또는 3이면 "남성"을 출력,
        // genderCode의 값이 2 또는 4이면 "여성"을 출력,
        // genderCode의 값이 1 ~ 4 이외의 값이면 "몰라요"를 출력.
        switch (genderCode) {
        case 1:
        case 3:
            System.out.println("남성");
            break;
        case 2:
        case 4:
            System.out.println("여성");
            break;
        default:
            System.out.println("몰라요");
        }

    }

}
