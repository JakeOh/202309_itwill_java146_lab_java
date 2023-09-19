package com.itwill.modifier04;

public class Member {
    // field
    private String memberId; // 읽기 전용 데이터
    private String memberPassword; // 읽기, 쓰기 가능 데이터
    
    // constructor - argument 2개를 갖는 생성자
    public Member(String memberId, String memberPassword) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
    }
    
    // getter/setter method
    public String getMemberId() {
        return this.memberId;
    }
    
    public String getMemberPassword() {
        return this.memberPassword;
    }
    
    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

}
