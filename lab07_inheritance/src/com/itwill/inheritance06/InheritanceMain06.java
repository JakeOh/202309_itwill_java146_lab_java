package com.itwill.inheritance06;

public class InheritanceMain06 {

    public static void main(String[] args) {
        // Point 타입 객체 생성
        Point p1 = new Point();
        System.out.println(p1); // toString 재정의
        
        Point p2 = new Point(0.0, 0.0);
        System.out.println(p2);
        
        System.out.println(p1.equals(p2)); // equals 재정의
        
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        
        System.out.println("----------");
        
        User user1 = new User();
        System.out.println(user1);
        
        User user2 = new User("admin", "0000");
        System.out.println(user2);
        
        User user3 = new User("admin", "1234");
        System.out.println(user3);
        
        // 비교 연산자 결과
        System.out.println("== 결과");
        System.out.println(user1 == user2); //-> false
        System.out.println(user2 == user3); //-> false
        
        // equals 메서드 결과
        System.out.println("equals 메서드 결과");
        System.out.println(user1.equals(user2)); //-> false
        System.out.println(user2.equals(user3)); //-> true

        // hashCode 결과
        System.out.println("hashCode 메서드 결과");
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
        
    }

}
