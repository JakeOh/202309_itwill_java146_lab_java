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
    
    /**
     * 아규먼트 index가 유효한 범위의 인덱스인 지를 검사.
     * index >= 0 이고, index가 배열에 저장된 원소 개수(count)보다 작으면 true, 
     * 그렇지 않으면 false.
     * 
     * @param index 유효한 지 검사할 인덱스. 정수(int) 타입.
     * @return true 또는 false.
     */
    public boolean isValidIndex(int index) {
        return index >= 0 && index < count;
    }
    
    /**
     * 회원 정보를 저장할 수 있는 배열에 빈 공간이 있으면 true, 그렇지 않으면 false를 리턴.
     * 배열(members)에 현재까지 저장된 원소 개수(count)가 배열의 길이보다 작으면 true.
     * 
     * @return true 또는 false.
     */
    public boolean isMemoryAvail() {
        return count < MAX_LENGTH;
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
        if (isMemoryAvail()) {
            members[count] = member;
            count++;
            result = 1;
        }
        
        return result;
    }

    @Override
    public Member read(int index) {
        if (isValidIndex(index)) {
            return members[index];
        } else {
            return null;
        }
    }

    @Override
    public int update(int index, String password) {
        int result = 0;
        
        if (isValidIndex(index)) {
            members[index].setPassword(password);
            result = 1;
        }
        
        return result;
    }

}
