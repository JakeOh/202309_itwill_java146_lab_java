package com.itwill.class05;

public class AppMain05 {

    public static void main(String[] args) {
        // Account 타입 객체 생성를 생성하고 메서드들을 테스트.

        Account account1 = new Account(123456, 10_000);
        System.out.println(account1);
        account1.info();
        
        Account account2 = new Account(123789, 1_000);
        System.out.println(account2);
        account2.info();
        
        account1.deposit(2_000);
        account1.info();
        
        account1.deposit(-100);
        account1.info();
        
        account1.withdraw(3_000);
        account1.info();
        
        account1.withdraw(10_000);
        
    }

}
