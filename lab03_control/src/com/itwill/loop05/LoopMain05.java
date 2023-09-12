package com.itwill.loop05;

public class LoopMain05 {

    public static void main(String[] args) {
        // 반복문에서 break와 continue 문장:
        // break: 반복문 실행 중에 break 문장을 만나면, break가 포함된 가장 가까운 반복문 블록을 끝냄.
        // continue: 반복문 실행 중에 continue 문장을 만나면, 
        // continue 아래의 코드들은 무시하고 그 다음 반복 과정을 계속 수행.
        
        for (int n = 1; n <= 5; n++) {
            if (n == 3) {
                break;
            }
            System.out.println(n);
        }
        
        System.out.println("----------");
        
        for (int n = 1; n <= 5; n++) {
            if (n == 3) {
                continue;
            }
            System.out.println(n);
        }
        
        System.out.println("----------");
        
        // break 문장 활용 - 무한 반복문을 종료시킬 때.
        // for 구문에서 조건식이 없는 경우는 무한 반복문.
        for (int n = 1; ; n++) {
            System.out.println(n);
            if (n == 5) {
                break;
            }
        }
        
    }

}
