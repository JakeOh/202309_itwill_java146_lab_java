package com.itwill.jdbc03;

import static com.itwill.jdbc.OracleJdbc.PASSWORD;
import static com.itwill.jdbc.OracleJdbc.URL;
import static com.itwill.jdbc.OracleJdbc.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class JdbcMain03 {

    public static void main(String[] args) {
        // JDBC delete
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 오라클 드라이버(라이브러리)를 등록:
            DriverManager.registerDriver(new OracleDriver());
            
            // 오라클 데이터베이스에 접속:
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Statement를 준비:
            final String sql = "delete from BLOGS where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 10); // 첫번째 물음표를 10로 채움.
            
            // Statement 실행 & 결과 처리:
            int result = pstmt.executeUpdate();
            System.out.println(result + "개 행이 삭제됐습니다.");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
