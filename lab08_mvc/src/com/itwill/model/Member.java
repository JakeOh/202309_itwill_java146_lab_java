package com.itwill.model;

// MVC 아키텍쳐에서 Model 역할 담당하는 클래스 - 데이터
// VO(Value Object), DTO(Data Transfer Object)
public class Member {
    private String id;
    private String password;
    
    public Member() {}

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Member(id=" + this.id + ", password=" + this.password + ")";
    }
    
}
