package com.itwill.exception06;

public class Calculator {
    
    public int divide(int x, int y) throws Exception {
        if (y != 0) {
            return x / y; // 메서드를 호출한 곳에 값을 반환.
        }
        
        // 메서드를 호출한 곳에 예외를 던짐.
        throw new Exception("y는 0이 될 수 없음!");
    }

}
