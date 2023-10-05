package com.itwill.list04;

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
        return "Member [id=" + id + ", password=" + password + "]";
    }

    @Override
    // id가 일치하면 equals는 true, 그렇지 않으면 false를 리턴.
    public boolean equals(Object obj) {
        boolean result = false;
        if (id != null && obj instanceof Member) {
            Member m = (Member) obj;
            result = this.id.equals(m.id);
        }
        
        return result;
    }
    
    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : 0;
    }
    
}
