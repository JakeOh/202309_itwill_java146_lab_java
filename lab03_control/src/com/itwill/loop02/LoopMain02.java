package com.itwill.loop02;

public class LoopMain02 {

    public static void main(String[] args) {
        // 출력결과: 0 2 4 6 8 10 
        for (int n = 0; n <= 10; n += 2) {
            System.out.print(n + " ");
        }
        
        System.out.println(); // 줄바꿈
        
        for (int n = 0; n <= 5; n++) {
            System.out.print((n * 2) + " ");
        }
        
        System.out.println();
        
        for (int n = 0; n <= 10; n++) {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
        }
        
        System.out.println();

    }

}
