package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain01 {
    private static final int MAX_LENGTH = 5; // 배열의 길이(원소 개수)
    
    private Scanner scanner = new Scanner(System.in); // 입력 도구
    private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처들을 저장할 배열
    private int count = 0; // 배열 contacts에 저장된 연락처 개수를 저장하는 변수.
    // 배열에 새로운 연락처가 저장될 때마다 증가(++).

    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.1 ***");
        
        ContactMain01 app = new ContactMain01();
        
        boolean run = true; // 프로그램 실행(true)/종료(false) 여부를 저장하는 변수.
        while (run) {
            int menu = app.showMainMenu();
            switch (menu) {
            case 0: // 종료
                run = false;
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
            } // end switch
        } //end while
        
        System.out.println("*** 프로그램 종료 ***");
    } // end main
    
    private int showMainMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("[0]종료 | [1]저장 | [2]새 연락처 | [3]인덱스 검색 | [4]수정");
        System.out.println("------------------------------------------------------------");
        System.out.print("선택> ");
        int menu = Integer.parseInt(scanner.nextLine());
        
        return menu;
    }
    

} // end class
