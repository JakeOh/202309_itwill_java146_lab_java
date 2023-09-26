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
            case 3: // 인덱스 검색
                app.readMemberByIndex();
                break;
            case 4: // 비밀번호 변경
                app.updatePassword();
                break;
            default:
                System.out.println("메뉴를 다시 선택하세요...");
            } // end switch
        } // end while
        
        System.out.println("*** 프로그램 종료 ***");
    } // end main

    public void updatePassword() {
        System.out.println("\n----- 비밀번호 변경 -----");
        
        System.out.print("변경할 인덱스> ");
        int index = Integer.parseInt(scanner.nextLine());
        // index >= 0 && index < dao.getCount(): 유효한 인덱스
        // index < 0 || index >= dao.getCount(): 유효하지 않은(회원 정보가 없는) 인덱스
        if (!dao.isValidIndex(index)) {
            System.out.println("> 해당 인덱스에는 회원 정보가 없음.");
            return; // 메서드 종료
        }
        
        System.out.print("새 비밀번호> ");
        String password = scanner.nextLine();
        
        int result = dao.update(index, password);
        if (result == 1) {
            System.out.println("> 비밀번호 변경 성공");
        } else {
            System.out.println("> 비밀번호 변경 실패");
        }
    }
    
    public void readMemberByIndex() {
        System.out.println("\n----- 인덱스 검색 -----");
        System.out.print("검색할 인덱스> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        Member m = dao.read(index);
        if (m != null) {
            System.out.println("결과> " + m);
        } else {
            System.out.println("> 해당 인덱스에는 회원 정보가 없음.");
        }
        System.out.println("-----------------------");
    }

    public void createNewMember() {
        System.out.println("\n----- 새 회원 등록 -----");
        
        if (!dao.isMemoryAvail()) { // dao.getCount() >= MAX_LENGTH
            System.out.println("> 저장 공간이 부족...");
            return; // 메서드 종료
        }
        
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
