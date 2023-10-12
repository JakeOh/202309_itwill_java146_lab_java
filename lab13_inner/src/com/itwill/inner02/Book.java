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
    
    // 생성자 오버로딩(overloading):
    // 파라미터(개수, 타입)가 다른 생성자들을 여러개 작성.
    // Book(String title, String author) 생성자가 있는 경우,
    // Book(String title, String publisher), Book(String author, String publisher) 생성자는 오버로딩할 수 없음.
    
    @Override
    public String toString() {
        return String.format("Book{제목=%s, 저자=%s, 출판사=%s}", 
                title, author, publisher);
    }

    //----- Builder(Factory) 디자인 패턴 -----//
    public static BookBuilder builder() {
        return new BookBuilder();
    }
    
    public static class BookBuilder {
        private String title;
        private String author;
        private String publisher;
        
        private BookBuilder() {}
        
        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }
        
        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }
        
        public BookBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }
        
        public Book build() {
            return new Book(title, author, publisher);
        }
        
    } // class BookBuilder
    
} // class Book
