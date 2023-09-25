package com.itwill.controller;

import com.itwill.model.Member;

// MVC 아키텍쳐에서 Controller 역할 담당하는 인터페이스.
// DAO(Data Access Object)
public interface MemberDao {
    /**
     * 전체 회원 목록 검색. 모든 회원 정보가 저장된 배열을 리턴.
     * 
     * @return Member 배열(Member[]).
     */
    Member[] read();
    
    /**
     * 새로운 회원 정보를 배열에 저장.
     * 
     * @param member 배열에 저장할 Member 타입 객체.
     * @return 배열에 회원 정보를 저장했으면 1, 저장 실패했으면 0.
     */
    int create(Member member);
    
    /**
     * 인덱스를 사용한 회원 정보 검색 기능.
     * 
     * @param index 배열에서 회원 정보를 검색할 인덱스. 0 이상의 정수(int).
     * @return 아규먼트 index가 배열의 인덱스 범위 안에 있으면 Member 타입 객체를 리턴.
     * index가 배열 범위 밖에 있거나, 해당 인덱스 배열 원소가 null이면 null을 리턴.
     */
    Member read(int index);
    
    /**
     * 회원 정보 업데이트 기능. 배열의 특정 인덱스의 회원 정보 중 비밀번호만 변경.
     * 
     * @param index 수정할 회원의 배열 인덱스. 0 이상의 정수.
     * @param password 업데이트할 새 비밀번호. 문자열.
     * @return 업데이트 성공하면 1, 실패하면 0.
     */
    int update(int index, String password);

}
