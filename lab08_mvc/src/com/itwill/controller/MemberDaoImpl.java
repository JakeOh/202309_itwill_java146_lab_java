package com.itwill.controller;

import com.itwill.model.Member;

// MVC 아키텍쳐에서 Controller 역할 담당 클래스 - DAO(Data Access Object)
public class MemberDaoImpl implements MemberDao {

    // singleton: (1) private static field + (2) private constructor + (3) public static method
    private static MemberDaoImpl instance; // singleton (1)
    
    // singleton (2)
    private MemberDaoImpl() {}
    
    // singleton (3)
    public static MemberDaoImpl getInstance() {
        if (instance == null) { // MemberDaoImpl 타입 객체가 생성되어 있지 않은 경우
            instance = new MemberDaoImpl(); // MemberDaoImpl 타입 객체 생성
        }
        
        return instance;
    }
    
    public static final int MAX_LENGTH = 2; // 배열 최대 길이(원소 개수)
    
    private Member[] members = new Member[MAX_LENGTH]; // 회원 정보 배열
    
    private int count = 0; // 현재까지 배열에 저장된 원소 개수. 배열에 원소가 저장될 때마다 ++.
    
    public int getCount() {
        return count;
    }
    
    @Override
    public Member[] read() {
        // members를 그대로 리턴하지 말고, 실제 저장된 원소 개수 크기 만큼의 배열만 리턴.
        Member[] memberArray = new Member[count];
        for (int i = 0; i < count; i++) {
            memberArray[i] = members[i];
        }
        
        return memberArray;
    }

    @Override
    public int create(Member member) {
        int result = 0;
        if (count < MAX_LENGTH) {
            members[count] = member;
            count++;
            result = 1;
        }
        
        return result;
    }

    @Override
    public Member read(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(int index, String password) {
        // TODO Auto-generated method stub
        return 0;
    }

}
