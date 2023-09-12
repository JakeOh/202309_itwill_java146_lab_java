package com.itwill.loop09;

public class LoopMain09 {

    public static void main(String[] args) {
        // 중첩 while 문을 사용. 구구단 2단부터 9단까지 출력.
        int dan = 2;
        while (dan < 10) {
            System.out.println("--- " + dan + "단 ---");
            
            int n = 1;
            while (n < 10) {
                System.out.println(dan + " x " + n + " = " + (dan * n));
                n++;
            }
            
            dan++;
        }

    }

}
