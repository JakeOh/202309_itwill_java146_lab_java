package com.itwill.file05;

import java.io.Serializable;

public class Product implements Serializable {
    private int id; // 상품 아이디
    private String name; // 상품 이름
    private int price; // 상품 가격

    public Product() {}

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Product(id=" + id + ", name=" + name + ", price=" + price + ")";
    }
    
}
