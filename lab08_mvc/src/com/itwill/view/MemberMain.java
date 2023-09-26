package com.itwill.view;

import java.util.Scanner;

import com.itwill.controller.MemberDaoImpl;

// MVC(Model-View-Controller) 아키텍쳐에서 View 역할 담당 클래스 - UI
public class MemberMain {
    
    private Scanner scanner = new Scanner(System.in);
    private MemberDaoImpl dao = MemberDaoImpl.getInstance();

    public static void main(String[] args) {
        System.out.println("*** 회원 관리 프로그램 ***");
        
        MemberMain app = new MemberMain();
        
        boolean run = true; // 프로그램 종료할 때 false로 변경.
        while (run) {
            int menu = app.selectMainMenu();
            switch (menu) {
            case 0: // 종료
                run = false;
                break;
            case 1: // 회원 정보 전체 목록 보기
                break;
            default:
                System.out.println("메뉴를 다시 선택하세요...");
            } // end switch
        } // end while
        
        System.out.println("*** 프로그램 종료 ***");
    } // end main

    public int selectMainMenu() {
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("[0]종료 | [1]전체 목록 | [2]새 회원 등록 | [3]인덱스검색 | [4]비밀번호 변경");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("선택> ");
        
        int menu = Integer.parseInt(scanner.nextLine());
        
        return menu;
    }
    
} // end class MemberMain
