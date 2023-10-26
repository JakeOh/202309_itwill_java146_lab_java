package com.itwill.jdbc.controller;

import static com.itwill.jdbc.OracleJdbc.PASSWORD;
import static com.itwill.jdbc.OracleJdbc.URL;
import static com.itwill.jdbc.OracleJdbc.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.OracleDriver;

// MVC 아키텍쳐에서 Controller에 해당하는 클래스: 
// DB CRUD(Create, Read, Update, Delete) : select, insert, update, delete
public class BlogDao {
    //----- singleton -----
    private static BlogDao instance = null;
    
    private BlogDao() {
        // 오라클 데이터베이스를 접속할 수 있는 드라이버(라이브러리)를 등록.
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static BlogDao getInstance() {
        if (instance == null) {
            instance = new BlogDao();
        }
        
        return instance;
    }
    //----- singleton -----
    
    private Blog makeBlogFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("ID");
        String title = rs.getString("TITLE");
        String content = rs.getString("CONTENT");
        String author = rs.getString("AUTHOR");
        LocalDateTime created = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
        LocalDateTime modified = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();
        
        Blog blog = new Blog(id, title, content, author, created, modified);
        
        return blog;
    }
    
    public static final String SQL_SELECT_ORDER_BY_ID = 
            "select * from BLOGS order by ID desc";
    
    /**
     * 데이터베이스의 BLOGS 테이블에서 모든 레코드(행)를 검색해서 리스트를 리턴.
     * SQL_SELECT_ORDER_BY_ID 실행. 검색 결과는 블로그 포스트 번호의 내림차순으로 정렬.
     * 테이블에 행이 1개도 없는 경우에는 빈 리스트를 리턴.
     * 
     * @return 블로그들의 리스트.
     */
    public List<Blog> read() {
        List<Blog> result = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // 오라클 데이터베이스에 접속(세션 생성)
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 실행할 Statement 객체를 생성
            stmt = conn.prepareStatement(SQL_SELECT_ORDER_BY_ID);
            // SQL 문장을 데이터베이스에서 실행
            rs = stmt.executeQuery();
            
            // 결과 처리
            while (rs.next()) {
                Blog blog = makeBlogFromResultSet(rs);
                result.add(blog);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    public static final String SQL_INSERT = 
            "insert into BLOGS (TITLE, CONTENT, AUTHOR) values (?, ?, ?)";
    
    /**
     * 데이터베이스의 BLOGS 테이블에 행을 삽입(insert). SQL_INSERT를 실행.
     * 
     * @param blog 테이블에 insert할 제목(title), 내용(content), 작성자(author) 값을 저장한 객체.
     * @return 테이블에 삽입된 행의 개수.
     */
    public int create(Blog blog) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setString(3, blog.getAuthor());
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    public static final String SQL_DELETE_BY_ID = 
            "delete from BLOGS where ID = ?";
    
    /**
     * 데이터베이스 BLOGS 테이블에서 글 번호(id)에 해당하는 레코드를 삭제.
     * SQL_DELETE_BY_ID 문장을 실행. 삭제된 행의 개수를 리턴.
     * 
     * @param id 삭제하려는 포스트의 번호(ID). 테이블의 PK.
     * @return 삭제 성공이면 1, 실패이면 0.
     */
    public int delete(Integer id) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_DELETE_BY_ID);
            stmt.setInt(1, id);
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    public static final String SQL_SELECT_BY_ID = "select * from BLOGS where ID = ?";
    
    /**
     * 블로그 포스트 아이디(글 번호)로 검색해서 그 결과를 리턴.
     * SQL_SELECT_BY_ID 문장을 실행.
     * 
     * @param id 테이블에서 검색할 때 사용할 아이디(PK).
     * @return 검색 결과가 있으면 null이 아닌 Blog 타입 객체, 검색 결과가 없으면 null.
     */
    public Blog read(Integer id) {
        Blog blog = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) { // 검색 결과가 있으면(PK에 해당하는 레코드가 있으면)
                blog = makeBlogFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return blog;
    }
    
}
