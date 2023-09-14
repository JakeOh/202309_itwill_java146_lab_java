package com.itwill.method02;

public class MethodMain02 {

    public static void main(String[] args) {
        // 리턴 타입과 아규먼트를 갖는 메서드 작성, 호출 연습
        
        // 같은 클래스의 메서드를 호출할 때는 메서드 이름으로만 호출할 수 있음.
        double result = add(1.0, 2.0);
        System.out.println("add = " + result);

        // subtract, multiply, divide 호출, 결과 확인.
        result = subtract(1, 2);
        System.out.println("subtract = " + result);
        
        result = multiply(1, 2);
        System.out.println("multiply = " + result);
        
        System.out.println("divide = " + divide(1, 2));
        
    } // end main
    
    /**
     * 숫자 2개를 전달받아서, 두 숫자의 덧셈 결과를 반환.
     * 
     * @param x double.
     * @param y double.
     * @return x + y.
     */
    public static double add(double x, double y) {
        return x + y;
    } // end add
    
    /**
     * subtract.
     * 숫자 2개를 전달 받아서, 첫번째 아규먼트에서 두번째 아규먼트를 뺀 결과를 리턴.
     * 
     * @param x double.
     * @param y double.
     * @return x - y.
     */
    public static double subtract(double x, double y) {
        return x - y;
    } // end subtract
    
    /**
     * multiply.
     * 숫자 2개를 전달 받아서 두 수의 곱셈 결과를 리턴.
     * 
     * @param x double.
     * @param y double.
     * @return x * y.
     */
    public static double multiply(double x, double y) {
        return x * y;
    }
    
    /**
     * divide.
     * 숫자 2개를 전달 받아서 첫번째 아규먼트를 두번째 아규먼트로 나눈 결과를 리턴.
     * 
     * @param x double.
     * @param y double.
     * @return x / y.
     */
    public static double divide(double x, double y) {
        return x / y;
    }

} // end class
