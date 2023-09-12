package com.itwill.loop12;

import java.util.Random; // 난수를 생성하는 기능을 가지고 있는 타입

public class LoopMain12 {

    public static void main(String[] args) {
        // 교재 연습문제 3(p.161)
        // 주사위 2개를 던졌을 때의 결과를 (주사위1, 주사위2) 형식으로 출력.
        // 주사위 2개 눈의 합이 5가 되면 실행을 멈춤. (예) (1, 4), (2, 3), ...
        // 무한 반복문:
        // (1) for ( ; ; ) { ... }
        // (2) while (true) { ... }
        
        System.out.println("--- 교재 Ex3. ---");
        
        Random random = new Random();
        
        // 무한 반복문 시작
        while (true) {
            // 첫번째 주사위 눈
            int dice1 = random.nextInt(1, 7); // 1이상 7미만의 정수 난수를 만듦.
            
            // 두번째 주사위 눈
            int dice2 = random.nextInt(1, 7);
            
            // 두 주사위의 눈을 출력
            System.out.printf("(%d, %d)\n", dice1, dice2);
            
            // 무한 반복문 종료 조건
            if (dice1 + dice2 == 5) {
                break; // 반복문 종료
            }
        }

        System.out.println("--- 교재 Ex4. ---");
        // x, y: 10 이하의 자연수(1, 2, 3, ..., 8, 9, 10)
        // 4x + 5y = 60을 만족하는 모든 x, y를 찾으세요.
        // (예) (x=5, y=8), ...
        for (int x = 1; x <= 10; x++) { // x를 1부터 10까지 1씩 증가시키면서 반복
            for (int y = 1; y <= 10; y++) { // y를 1부터 10까지 1씩 증가시키면서 반복
                if (4 * x + 5 * y == 60) { // 방정식의 해(답)이 되는 지를 검사
                    System.out.printf("x = %d, y = %d\n", x, y); // 방정식의 해(답)을 출력
                    break;
                }
            }
        }
        
    }

}
