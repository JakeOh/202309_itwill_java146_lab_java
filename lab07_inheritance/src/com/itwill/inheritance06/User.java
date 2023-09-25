package com.itwill.inheritance06;

public class User {
    // field
    private String id;
    private String password;
    
    // 생성자 - 기본 생성자, 아규먼트 2개인 생성자
    public User() {}
    
    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    // toString 재정의
    @Override
    public String toString() {
        return "User(id=" + this.id + ", password=" + this.password + ")";
    }
    
    // equals 재정의 - id가 같으면 true, 그렇지 않으면 false.
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        
        if (obj instanceof User) {
            User other = (User) obj; // 타입 변환(casting)
            if (this.id != null) { // null이 아닌 경우에만 메서드 호출 가능!
                result = this.id.equals(other.id); // String 비교할 때 equals 메서드 사용!
            }
        }
        
        return result;
    }
    
    // hashCode 재정의
    @Override
    public int hashCode() {
        if (this.id != null) {
            return this.id.hashCode();
        } else {
            return 0;
        }
    }

}
