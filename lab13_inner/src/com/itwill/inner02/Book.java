package com.itwill.inner02;

public class Book {
    // field
    private String title; // 책 제목
    private String author; // 책 저자
    private String publisher; // 출판사
    
    // constructors
    public Book() {}
    
    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
    
    public Book(String title) {
//        this.title = title;
        this(title, null, null); // 다른 생성자 호출
    }
    
    public Book(String title, String author) {
//        this.title = title;
//        this.author = author;
        this(title, author, null);
    }

}
