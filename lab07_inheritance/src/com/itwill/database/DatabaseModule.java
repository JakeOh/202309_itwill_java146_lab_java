package com.itwill.database;

public interface DatabaseModule {
    // 필드
    int DB_VERSION = 1; // public static final 생략.

    /**
     * 데이터베이스의 테이블에서 자료들을 읽어서 정수를 리턴하는 기능.
     * 
     * @return 검색된 자료 개수.
     */
    int select(); // public abstract 생략.
    
    /**
     * 데이터베이스의 테이블에 문자열을 저장하는 기능.
     * 
     * @param value. 테이블에 저장할 문자열.
     * @return 저장 성공하면 1, 실패하면 0.
     */
    int insert(String value);
    
}
