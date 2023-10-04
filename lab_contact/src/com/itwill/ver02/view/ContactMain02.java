package com.itwill.ver02.view;

import java.util.Scanner;

import com.itwill.ver02.controller.ContactDaoImpl;
import com.itwill.ver02.model.Contact;

public class ContactMain02 {
    
    private Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();

    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.2 ***");
        
        ContactMain02 app = new ContactMain02();
        
        boolean run = true;
        while (run) {
            int menu = app.selectMainMenu();
            switch (menu) {
            case 0:
                run = false;
                break;
            case 1:
                app.readAllContacts();
                break;
            case 2:
                app.createNewContact();
                break;
            case 3:
                app.readContactByIndex();
                break;
            case 4:
                app.updateContact();
                break;
            default:
                System.out.println("> 메뉴를 다시 선택하세요.");
            }
        }
        
        System.out.println("프로그램 종료");
    }

    private void updateContact() {
        System.out.println("\n----- 연락처 업데이트 -----");
        System.out.print("업데이트할 연락처의 인덱스> ");
        int index = Integer.parseInt(scanner.nextLine());
        if (!dao.isValidIndex(index)) {
            System.out.println("> 해당 인덱스에는 연락처 정보가 없음");
            return;
        }
        
        Contact before = dao.read(index);
        System.out.println("> 수정 전: " + before);
        
        System.out.print("이름> ");
        String name = scanner.nextLine();
        System.out.print("전화번호> ");
        String phone = scanner.nextLine();
        System.out.print("이메일> " );
        String email = scanner.nextLine();
        
        Contact after = new Contact(name, phone, email);
        int result = dao.update(index, after);
        if (result == 1) {
            System.out.println("> 연락처 업데이트 성공");
        } else {
            System.out.println("> 연락처 업데이트 실패");
        }
    }

    private void readContactByIndex() {
        System.out.println("\n----- 인덱스 검색 -----");
        System.out.print("검색할 인덱스> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        if (!dao.isValidIndex(index)) {
            System.out.println("> 해당 인덱스에는 연락처 정보가 없음");
            return;
        }
        
        Contact contact = dao.read(index);
        System.out.println("> " + contact);
    }

    private void createNewContact() {
        System.out.println("\n----- 새 연락처 -----");
        if (!dao.isMemoryAvail()) {
            System.out.println("> 저장 공간 부족");
            return;
        }
        
        System.out.print("이름 입력> ");
        String name = scanner.nextLine();
        System.out.print("전화번호 입력> ");
        String phone = scanner.nextLine();
        System.out.print("이메일 입력> ");
        String email = scanner.nextLine();
        
        Contact contact = new Contact(name, phone, email); // Contact 타입 객체 생성
        
        int result = dao.create(contact); // Controller(DAO)를 사용해서 연락처 저장.
        if (result == 1) {
            System.out.println("> 연락처 저장 성공");
        } else {
            System.out.println("> 연락처 저장 실패");
        }
    }

    private void readAllContacts() {
        System.out.println("\n----- 연락처 목록 -----");
        
        Contact[] contacts = dao.read();
        for (int i = 0; i < contacts.length; i++) {
            System.out.printf("[%d] %s\n", i, contacts[i]);
        }
        
        System.out.println("-----------------------");
    }

    private int selectMainMenu() {
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("[0]종료 | [1]목록 | [2]새 연락처 | [3]인덱스 검색 | [4]업데이트");
        System.out.println("---------------------------------------------------------------");
        System.out.print("선택> ");
        
        int menu = Integer.parseInt(scanner.nextLine());
        
        return menu;
    }

}
