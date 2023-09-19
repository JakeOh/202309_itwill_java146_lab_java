package com.itwill.modifier04;

public class MemberTest {

    public static void main(String[] args) {
        // Member 타입 객체 생성
        Member m = new Member("admin", "1234");
        
        // 아이디와 비밀번호 출력
        System.out.println("ID: " + m.getMemberId());
        System.out.println("PWD: " + m.getMemberPassword());
        
        // 비밀번호 변경, 확인
        m.setMemberPassword("!@#$");
        System.out.println("PWD: " + m.getMemberPassword());

    }

}
