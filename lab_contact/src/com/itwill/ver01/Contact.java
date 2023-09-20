package com.itwill.ver01;

// 연락처 데이터 클래스
public class Contact {
    // 필드
    private String name;
    private String phone;
    private String email;
    
    // 생성자
    public Contact() {} // 기본 생성자

    // 아규먼트를 갖는 생성자
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // 연락처 정보(이름, 전화번호, 이메일)를 문자열로 만들어서 리턴하는 메서드.
    public String toString() {
        return "Contact(name=" + this.name 
                + ", phone=" + this.phone
                + ", email=" + this.email
                + ")";
                
    }
    
}
