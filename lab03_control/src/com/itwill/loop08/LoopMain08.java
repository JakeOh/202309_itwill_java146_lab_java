package com.itwill.loop08;

public class LoopMain08 {

    public static void main(String[] args) {
        // while 반복문
        
        System.out.println("----- [1] -----");
        int n = 1; // 시작 값
        while (n <= 5) { // 반복할 조건
            // 반복할 문장(들)
            System.out.println(n);
            n++;
        }
        
        System.out.println("----- [2] -----");
        // 5 4 3 2 1 순서로 출력
        n = 5;
        while (n > 0) {
            System.out.println(n);
            n--;
        }
        
        System.out.println("----- [3] -----");
        // 0 2 4 6 8 10 출력
        n = 0;
        while (n <= 10) {
            System.out.print(n + " ");
            n += 2; // n = n + 2;
        }
        System.out.println();
        
        n = 0;
        while (n <= 10) {
            if (n % 2 == 0) { // n이 짝수이면
                System.out.print(n + " ");
            }
            n++;
        }
        System.out.println();
        
        n = 0;
        while (n <= 5) {
            System.out.print((2 * n) + " ");
            n++;
        }
        System.out.println();
        
        System.out.println("----- [4] -----");
        // 9 7 5 3 1 출력
        n = 9;
        while (n > 0) {
            System.out.print(n + " ");
            n -= 2; // n = n - 2;
        }
        System.out.println();
        
        n = 9;
        while (n > 0) {
            if (n % 2 == 1) { // n이 홀수이면
                System.out.print(n + " ");
            }
            n--;
        }
        System.out.println();

        System.out.println("----- [5] -----");
        // 구구단 9단 출력
        int x = 9;
        int y = 1;
        while (y < 10) {
            System.out.println(x + " x " + y + " = " + (x * y));
            y++;
        }
        
    }

}
