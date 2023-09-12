package com.itwill.loop07;

public class LoopMain07 {

    public static void main(String[] args) {
        // 구구단 출력:
        // 2단은 (2 x 2)까지, 3단은 (3 x 3)까지, 4단은 (4 x 4)까지, ..., 9단은 (9 x 9)까지 출력.

        // (1) break 사용:
        for (int x = 2; x < 10; x++) {
            System.out.println("--- " + x + "단 ---");
            for (int y = 1; y < 10; y++) {
                System.out.println(x + " x " + y + " = " + (x * y));
                if (y == x) {
                    break;
                }
            }
        }
        
        System.out.println("\n==========\n");
        
        for (int x = 2; x < 10; x++) {
            System.out.println("--- " + x + "단 ---");
            for (int y = 1; y <= x; y++) {
                System.out.println(x + " x " + y + " = " + (x * y));
            }
        }
        
        
    }

}
