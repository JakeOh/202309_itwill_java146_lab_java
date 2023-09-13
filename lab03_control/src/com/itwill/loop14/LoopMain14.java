package com.itwill.loop14;

import java.util.Scanner;

public class LoopMain14 {

    public static void main(String[] args) {
        // 교재 연습문제 7.
        
        boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하는 변수.
        // run이 true인 경우에는 프로그램을 계속 실행, false인 경우에는 프로그램 종료.
        
        int balance = 0; // 은행 계좌 잔고를 저장할 변수.
        
        Scanner sc = new Scanner(System.in); // 콘솔 입력 장치.
        
        while (run) {
            System.out.println("-----------------------------------");
            System.out.println("1.입금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("-----------------------------------");
            System.out.print("선택> ");
            
            int menu = Integer.parseInt(sc.nextLine());
            // Scanner로 한 줄 입력받은 문자열을 int로 변환(parse)해서 저장.
            
            switch (menu) {
            case 1: // 입금(예금)
                System.out.print("입금액> ");
                int deposit = Integer.parseInt(sc.nextLine()); // 입금액 입력
                balance += deposit; // 잔고에 입금액을 더함.
                break;
            case 2: // 출금
                System.out.print("출금액> ");
                int withdraw = Integer.parseInt(sc.nextLine()); // 출금액 입력
                balance -= withdraw; // 잔고에서 출금액을 뺌.
                break;
            case 3: // 잔고
                System.out.println("잔고: " + balance);
                break;
            case 4: // 종료
                run = false;
                break;
            default:
                System.out.println("메뉴를 다시 선택하세요...");
            }
            
        }
        
        System.out.println("=== 프로그램 종료 ===");
    }

}
