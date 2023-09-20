package com.itwill.modifier07;

public class ProductTest {

    public static void main(String[] args) {
        // Product 타입 객체 생성, getter/setter 메서드 테스트.

        // 객체 생성
        Product prod = new Product(100, "아이폰15", 10_000);
        System.out.println(prod);
        
        // getter 테스트
        System.out.println("코드: " + prod.getProductCode());
        System.out.println("상품명: " + prod.getProductName());
        System.out.println("가격: " + prod.getProductPrice());
        
        // setter 테스트
        prod.setProductName("iPhone15 Pro");
        prod.setProductPrice(100_000);
        prod.info();

    }

}
