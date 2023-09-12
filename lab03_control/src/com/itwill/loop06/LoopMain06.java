package com.itwill.loop06;

public class LoopMain06 {

    public static void main(String[] args) {
        // 중첩 반복문
        
        for (int dan = 2; dan < 10; dan++) {
            System.out.println("----- " + dan + "단 -----");
            for (int n = 1; n < 10; n++) {
                System.out.println(dan + " x " + n + " = " + (dan * n));
            }
        }

    }

}
