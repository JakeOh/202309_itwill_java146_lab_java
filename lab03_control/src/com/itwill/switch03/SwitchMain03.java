package com.itwill.switch03;

public class SwitchMain03 {

    public static void main(String[] args) {
        // Weekday 타입의 변수를 선언하고 초기화:
        Weekday day = Weekday.SAT;
        
        switch (day) {
        case MON:
            System.out.println("회사 가기 싫어...");
            break;
        case TUE:
        case WED:
        case THU:
            System.out.println("일해야지...");
            break;
        case FRI:
            System.out.println("불금...");
            break;
        case SAT:
        case SUN:
            System.out.println("집에서 쉬어야지...");
            break;
        }

    }

}
