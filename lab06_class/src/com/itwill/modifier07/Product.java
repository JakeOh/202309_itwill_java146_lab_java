package com.itwill.modifier07;

// 상품 클래스
public class Product {
    // field
    private int productCode; // 상품 코드값(읽기 전용)
    private String productName; // 상품 이름(읽기, 쓰기 가능)
    private int productPrice; // 상품 가격(읽기, 쓰기 가능)
    
    // constructor - argument 3개를 갖는 생성자.
    public Product(int productCode, String productName, int productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // getter/setter method
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCode() {
        return productCode;
    }
    
    // 상품 정보(코드, 이름, 가격)를 출력하는 메서드
    public void info() {
        System.out.printf("Product(code=%d, name=%s, price=%d)\n", 
                this.productCode, this.productName, this.productPrice);
    }

}
