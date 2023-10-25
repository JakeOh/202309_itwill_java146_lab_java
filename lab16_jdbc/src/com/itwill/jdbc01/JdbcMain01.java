package com.itwill.jdbc01;

// public static으로 선언된 상수, 메서드 이름 import
import static com.itwill.jdbc.OracleJdbc.PASSWORD;
import static com.itwill.jdbc.OracleJdbc.URL;
import static com.itwill.jdbc.OracleJdbc.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.OracleDriver; // ojdbc11.jar에 포함된 클래스

/*
 * JDBC(Java Database Connectivity):
 * 자바 프로그램에서 데이터베이스를 연결하고, SQL 문장들을 실행해서 그 결과를 처리.
 * 
 * 1. Oracle JDBC 라이브러리(ojdbc11-x.x.x.x.jar)를 다운로드하고 이클립스 프로젝트에 추가.
 *    (1) search.maven.org 사이트에서 com.oracle.database.jdbc:ojdbc11 라이브러리를 다운로드.
 *    (2) 이클립스 프로젝트에 lib 폴더를 만들고, 다운로드 받은 라이브러리(jar)를 복사.
 *    (3) jar 파일 오른쪽 클릭 -> Build Path -> Add to build path
 * 2. 데이터베이스에 접속하기 위한 정보들(URL, USER, PASSWORD, ...)을 상수로 정의.
 * 3. 프로그램에서 오라클 JDBC 라이브러리를 메모리에 로딩.
 * 4. 오라클 데이터베이스에 접속.
 * 5. Statement 타입 객체 생성 - DB에서 실행할 SQL 문장을 작성하고, 실행할 수 있는 객체.
 * 6. Statement 타입 인스턴스에서 메서드를 호출해서 SQL을 실행.
 *    (1) executeQuery(): DQL(select 문장)
 *    (2) executeUpdate(): DML(insert, update, delete 문장)
 * 7. 실행 결과를 처리.
 * 8. 사용했던 모든 리소스를 해제(close).
 */

public class JdbcMain01 {

    public static void main(String[] args) {
        
        Connection conn = null; // 객체 생성-try 구문, 해제-finally 구문.
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 3. Oracle JDBC 라이브러리(드라이버)를 사용할 수 있도록 메모리에 로딩:
            DriverManager.registerDriver(new OracleDriver());
            System.out.println("오라클 드라이버 등록 성공");
            
            // 4. 오라클 데이터베이스에 접속(세션 생성):
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("오라클 데이터베이스 접속 성공");
            
            // 5. Statement 객체 생성.
            final String sql = "select * from BLOGS order by ID desc";
            //-> JDBC에서는 SQL 문장을 작성할 때 세미콜로(;)을 사용하지 않음!
            pstmt = conn.prepareStatement(sql);
            
            // 6. Statement를 실행 - SQL 문장을 DB 서버로 보내서 실행:
            rs = pstmt.executeQuery();
            
            // 7. 결과 처리:
            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String content = rs.getString("CONTENT");
                String author = rs.getString("AUTHOR");
                LocalDateTime createdTime = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
                LocalDateTime modifiedTime = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();
                
                Blog post = new Blog(id, title, content, author, createdTime, modifiedTime);
                System.out.println(post);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 8. 리소스 해제: 객체들이 생성된 순서의 반대로 해제.
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
