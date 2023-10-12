package com.itwill.inner01;

public class Outer {
    // field
    private int x;
    private int y;
    private String s;
    
    // constructor
    public Outer(int x, int y, String s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
    
    // method
    @Override
    public String toString() {
        return String.format("Outer{x=%d, y=%d, s=%s}", 
                this.x, this.y, this.s);
    }

    // static이 아닌 내부 클래스 선언:
    public class Inner {
        // field
        private int y;
        
        // constructor
        public Inner(int y) {
            this.y = y;
        }
        
        // method
        public void info() {
            System.out.println("--- Inner Class ---");
        }
    }
    
}
