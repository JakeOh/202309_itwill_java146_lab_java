package com.itwill.jdbc02;

import static com.itwill.jdbc.OracleJdbc.PASSWORD;
import static com.itwill.jdbc.OracleJdbc.URL;
import static com.itwill.jdbc.OracleJdbc.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcMain02 {

    public static void main(String[] args) {
        // JDBC insert
        
        Scanner sc = new Scanner(System.in);
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1. OracleDriver를 등록:
            DriverManager.registerDriver(new OracleDriver());
            
            // 2. Connection을 생성:
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // 3. Statement 준비:
            final String sql = "insert into BLOGS (TITLE, CONTENT, AUTHOR) values (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            
            // 테이블에 insert하기 위해서 필요한 정보들을 입력받음.
            System.out.print("제목 입력> ");
            String title = sc.nextLine();
            System.out.print("내용 입력> ");
            String content = sc.nextLine();
            System.out.print("작성자 입력> ");
            String author = sc.nextLine();
            
            // Statement 객체의 ?로 비워져 있는 부분에 값들을 채움.
            pstmt.setString(1, title); // 첫번째 물음표를 title 변수 값으로 채움.
            pstmt.setString(2, content);
            pstmt.setString(3, author);
            
            // 4. Statement를 실행 & 결과 처리:
            int result = pstmt.executeUpdate();
            System.out.println(result + "개 행이 삽입됐습니다.");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 리소스들 해제
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
