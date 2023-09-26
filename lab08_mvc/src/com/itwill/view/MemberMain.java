package com.itwill.view;

import java.util.Scanner;

import com.itwill.controller.MemberDaoImpl;
import com.itwill.model.Member;

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
                app.readAllMembers();
                break;
            case 2: // 새 회원 등록
                app.createNewMember();
                break;
            default:
                System.out.println("메뉴를 다시 선택하세요...");
            } // end switch
        } // end while
        
        System.out.println("*** 프로그램 종료 ***");
    } // end main

    public void createNewMember() {
        System.out.println("\n----- 새 회원 등록 -----");
        System.out.print("아이디 입력> ");
        String id = scanner.nextLine();
        System.out.print("비밀번호 입력> ");
        String password = scanner.nextLine();
        
        Member m = new Member(id, password);
        int result = dao.create(m);
        if (result == 1) {
            System.out.println("> 새 회원 등록 성공");
        } else {
            System.out.println("> 회원 등록 실패");
        }
    }

    public void readAllMembers() {
        System.out.println("\n----- 회원 전체 목록 -----");
        Member[] members = dao.read();
//        for (Member m : members) {
//            System.out.println(m);
//        }
        for (int i = 0; i < members.length; i++) {
            System.out.printf("[%d] %s\n", i, members[i]);
        }
        System.out.println("--------------------------");
    }

    public int selectMainMenu() {
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("[0]종료 | [1]전체 목록 | [2]새 회원 등록 | [3]인덱스검색 | [4]비밀번호 변경");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("선택> ");
        
        int menu = Integer.parseInt(scanner.nextLine());
        
        return menu;
    }
    
} // end class MemberMain
