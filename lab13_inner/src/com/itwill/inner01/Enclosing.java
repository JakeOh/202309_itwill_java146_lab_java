package com.itwill.inner01;

public class Enclosing {
    public static int var = 1; // static field
    private int x; // instance field
    
    public Enclosing(int x) {
        this.x = x;
    }
    
    // static method
    public static void test() {
        System.out.println("var = " + var);
        // System.out.println("x = " + this.x); //-> 컴파일 에러.
        //-> static 멤버는 다른 static 멤버들만 사용 가능. non-static 멤버는 사용 불가.
    }
    
    // instance(non-static) method
    @Override
    public String toString() {
        return String.format("Enclosing{var=%d, x=%d}", var, x);
        //-> 인스턴스 메서드는 static 또는 non-static 멤버들을 모두 사용할 수 있음.
    }

    public static class Nested {
        private int x;
        
        public Nested(int x) {
            this.x = x;
        }
        
        public void info() {
            System.out.println("--- Nested Class ---");
            System.out.println("x = " + x);
            // System.out.println(Enclosing.this.x); //-> 컴파일 에러
            //-> static 내부 클래스에서는 외부 클래스의 non-static 멤버를 사용할 수 없음!
            System.out.println("Enclosing.var = " + var); // Enclosing.var
        }
        
    } // class Nested
    
} // class Enclosing
