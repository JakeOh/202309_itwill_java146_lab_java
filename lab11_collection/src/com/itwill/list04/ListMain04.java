package com.itwill.list04;

import java.util.ArrayList;

public class ListMain04 {

    public static void main(String[] args) {
        // Member 타입을 저장하는 ArrayList를 선언, 객체 생성.
        ArrayList<Member> members = new ArrayList<>();
        
        // members에 Member 타입 객체를 저장.
        members.add(new Member("admin", "1111"));
        members.add(new Member("guest", "guest"));
        members.add(new Member("guest2", "2222"));
        members.add(new Member("guest3", "3333"));
        members.add(new Member("itwill", "0410"));
        
        // members의 내용을 출력
        System.out.println(members);
        
        // 향상된 for 구문을 사용해서 members의 원소들을 출력
        for (Member m : members) {
            System.out.println(m);
        }
        
        // 회원 아이디에 "est"가 포함된 모든 회원들을 저장하는 ArrayList를 만들고 출력.
        ArrayList<Member> list = new ArrayList<Member>();
        for (Member m : members) {
            if (m.getId().contains("est")) {
                list.add(m);
            }
        }
        System.out.println(list);

        // 리스트 members에서 아이디가 "guest"인 (첫번째) 회원 삭제
//        members.remove(1);
        
//        for (int i = 0; i < members.size(); i++) {
//            if (members.get(i).getId().equals("guest")) {
//                members.remove(i);
//                break;
//            }
//        }
        
//        for (Member m : members) {
//            if (m.getId().equals("guest")) {
//                members.remove(m);
//                break;
//            }
//        }
        
        // equals() 메서드가 override되어 있는 경우:
        members.remove(new Member("guest", null));
        
        System.out.println(members);
        
    }

}
