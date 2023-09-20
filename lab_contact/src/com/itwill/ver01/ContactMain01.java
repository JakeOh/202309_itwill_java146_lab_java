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
            case 1: // 배열에 저장된 전체 목록 출력
                app.readAllContacts();
                break;
            case 2: // 새 연락처 등록
                app.createContact();
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("메뉴를 다시 선택하세요...");
            } // end switch
        } //end while
        
        System.out.println("*** 프로그램 종료 ***");
    } // end main
    
    private void createContact() {
        System.out.println("--- 새 연락처 등록 ---");
        System.out.print("이름 입력> ");
        String name = scanner.nextLine();
        System.out.print("전화번호 입력> ");
        String phone = scanner.nextLine();
        System.out.print("이메일 입력> ");
        String email = scanner.nextLine();
        
        Contact c = new Contact(name, phone, email); // Contact 타입 객체 생성
        contacts[count] = c; // 연락처 객체를 배열에 저장.
        count++; // 배열에 저장된 연락처 개수를 1 증가.
    }
    
    private void readAllContacts() {
        System.out.println("--- 연락처 목록 ---");
        for (int i = 0; i < count; i++) { // 배열에 실제로 저장된 연락처 개수만큼 반복
            System.out.printf("[%d] %s\n", i, contacts[i].toString());
        }
        System.out.println("-------------------");
    }
    
    private int showMainMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("[0]종료 | [1]목록 | [2]새 연락처 | [3]인덱스 검색 | [4]수정");
        System.out.println("------------------------------------------------------------");
        System.out.print("선택> ");
        int menu = Integer.parseInt(scanner.nextLine());
        
        return menu;
    }
    

} // end class
