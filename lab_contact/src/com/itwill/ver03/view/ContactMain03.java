package com.itwill.ver03.view;

import java.util.List;
import java.util.Scanner;

import com.itwill.ver03.controller.ContactDaoImpl;
import com.itwill.ver02.model.Contact;

public class ContactMain03 {
    
    private Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();

    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.3 ***");
        
        ContactMain03 app = new ContactMain03();
        
        boolean run = true;
        while (run) {
            MainMenu menu = app.selectMainMenu();
            switch (menu) {
            case QUIT:
                run = false;
                break;
            case SELECT_ALL:
                app.readAllContacts();
                break;
            case CREATE:
                app.createNewContact();
                break;
            case SELECT_BY_INDEX:
                app.readContactByIndex();
                break;
            case UPDATE:
                app.updateContact();
                break;
            case DELETE:
                app.deleteContact();
                break;
            default:
                System.out.println("> 메뉴를 다시 선택하세요.");
            }
        }
        
        System.out.println("프로그램 종료");
    }
    
    private int inputInteger() {
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("정수 입력> ");
            }
        }
        
        return n;
    }
    
    private void deleteContact() {
        System.out.println("\n----- 연락처 삭제 -----");
        System.out.print("삭제할 연락처의 인덱스> ");
        int index = inputInteger();
        if (!dao.isValidIndex(index)) {
            System.out.println("> 해당 인덱스에는 연락처 정보가 없음");
            return;
        }
        
        int result = dao.delete(index);
        if (result == 1) {
            System.out.println("> 연락처 삭제 성공");
        } else {
            System.out.println("> 연락처 삭제 실패");
        }
    }

    private void updateContact() {
        System.out.println("\n----- 연락처 업데이트 -----");
        System.out.print("업데이트할 연락처의 인덱스> ");
        int index = inputInteger();
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
        int index = inputInteger();
        
        if (!dao.isValidIndex(index)) {
            System.out.println("> 해당 인덱스에는 연락처 정보가 없음");
            return;
        }
        
        Contact contact = dao.read(index);
        System.out.println("> " + contact);
    }

    private void createNewContact() {
        System.out.println("\n----- 새 연락처 -----");
        
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
        
        List<Contact> contacts = dao.read();
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("[%d] %s\n", i, contacts.get(i));
        }
        
        System.out.println("-----------------------");
    }

    private MainMenu selectMainMenu() {
        System.out.println("\n--------------------------------------------------------------------------");
        System.out.println("[0]종료 | [1]목록 | [2]새 연락처 | [3]인덱스 검색 | [4]업데이트 | [5] 삭제");
        System.out.println("--------------------------------------------------------------------------");
        System.out.print("선택> ");
        
        int n = inputInteger();
        
        return MainMenu.getMenu(n);
    }

}
