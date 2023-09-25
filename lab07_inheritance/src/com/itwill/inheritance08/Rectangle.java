package com.itwill.inheritance08;

public class Rectangle extends Shape {
    private double width; // 직사각형 가로 길이
    private double height; // 직사각형 세로 길이

    public Rectangle(double width, double height) {
        super("직사각형");
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }
    
}
