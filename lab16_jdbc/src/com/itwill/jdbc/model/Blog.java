package com.itwill.jdbc.model;

import java.time.LocalDateTime;

// 데이터베이스의 blogs 테이블의 컬럼들을 정의하는 모델 클래스:
public class Blog {
    // field
    private Integer id; // 글 번호(PK)
    private String title; // 글 제목
    private String content; // 글 내용
    private String author; // 작성자
    private LocalDateTime createdTime; // 작성 시간
    private LocalDateTime modifiedTime; // 수정 시간
    
    // constructors
    public Blog() {}

    public Blog(Integer id, String title, String content, String author, LocalDateTime createdTime,
            LocalDateTime modifiedTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    // getters
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    @Override
    public String toString() {
        return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", createdTime="
                + createdTime + ", modifiedTime=" + modifiedTime + "]";
    }
    
}
