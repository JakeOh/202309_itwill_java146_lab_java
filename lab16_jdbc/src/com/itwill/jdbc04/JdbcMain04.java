package com.itwill.jdbc04;

import static com.itwill.jdbc.OracleJdbc.PASSWORD;
import static com.itwill.jdbc.OracleJdbc.URL;
import static com.itwill.jdbc.OracleJdbc.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcMain04 {

    public static void main(String[] args) {
        // JDBC update
        
        Scanner sc = new Scanner(System.in);
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            final String sql = 
                    "update BLOGS set TITLE = ?, CONTENT = ?, MODIFIED_TIME = systimestamp where ID = ?";
            pstmt = conn.prepareStatement(sql);
            
            System.out.print("글 번호 입력> ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("제목 변경> ");
            String title = sc.nextLine();
            System.out.print("내용 변경> ");
            String content = sc.nextLine();
            
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, id);
            
            int result = pstmt.executeUpdate();
            System.out.println(result + "개 행이 업데이트됐습니다.");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        

    }

}
