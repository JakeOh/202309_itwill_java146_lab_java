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
        if (amount > 0) { // 출금액이 0보다 크면
            if (amount <= this.balance) { // 출금액이 잔고보다 작거나 같으면
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
     * transfer(이체). 내 계좌에서는 잔액에서 amount를 빼주고(출금), 
     * 상대방 계좌에서는 잔액에 amount를 더함(입금).
     * 
     * @param to 이체할 계좌(Account 타입).
     * @param amount 이체할 금액.
     * @return true.
     */
    public boolean transfer(Account to, int amount) {
//        this.balance -= amount; // 내 계좌에서 출금.
//        to.balance += amount; // 상대방 계좌에 입금.
        
        boolean result = false; // 이체 실패했을 때 반환 값.
        if (amount > 0) { // 이체 금액이 0보다 크면
            if (amount <= this.balance) { // 이체 금액이 내 계좌 잔고보다 작거나 같으면
                this.withdraw(amount); // 내 계좌에서 출금
                to.deposit(amount); // 상대방 계좌에 입금
                result = true; // 이체 성공 반환 값.
            } else {
                System.out.println("이체하기 위한 잔고가 부족합니다...");
            }
        } else {
            System.out.println("이체할 금액은 0보다 커야 합니다...");
        }
        
        return result;
    }
    
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
