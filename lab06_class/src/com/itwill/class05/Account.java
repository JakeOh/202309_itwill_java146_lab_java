package com.itwill.class05;

/**
 * 은행 계좌 정보.
 * 속성: 계좌번호(int), 잔고(int)
 * 기능: 입금, 출금, 이체, 정보 출력
 */
public class Account {
    // field
    int accountNo;
    int balance;
    
    // constructor - argument 2개를 갖는 생성자.
    public Account(int accountNo, int balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
    
    // method
    /**
     * deposit(입금). amount를 잔고에 더해줌.
     * 
     * @param amount 입금액.
     * @return 입금 후 잔액.
     */
    public int deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("입금액은 0보다 커야 합니다...");
        }
        
        return this.balance;
    }
    
    /**
     * withdraw(출금). amount를 잔고에서 뺌.
     * 
     * @param amount 출금액.
     * @return 출금 후 잔액.
     */
    public int withdraw(int amount) {
        if (amount > 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
            } else {
                System.out.println("잔액이 부족합니다...");
            }
        } else {
            System.out.println("출금액은 0보다 커야 합니다.");
        }
        
        return this.balance;
    }
    
    /**
     * transfer(이체). 내 계좌에서는 잔액에 amount를 더해주고, 
     * 상대방 계좌에서는 잔액에서 amount를 빼줌.
     * 
     * @param to 이체할 계좌(Account 타입).
     * @param amount 이체할 금액.
     * @return true.
     */
    
    /**
     * info(정보).
     * 계좌 번호, 현재 잔액을 출력.
     */
    public void info() {
        System.out.println("--- 계좌 정보 ---");
        System.out.println("계좌번호: " + this.accountNo);
        System.out.println("잔고: " + this.balance);
        System.out.println("-----------------");
    }

}
