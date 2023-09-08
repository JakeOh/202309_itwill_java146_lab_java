package com.itwill.variable05;

public class VariableMain05 {

    public static void main(String[] args) {
        // boolean 타입: 논리 타입. true(참) 또는 false(거짓)만을 저장할 수 있는 변수.
        // 비교 연산자: ==, !=, >, >=, <, <=
        // 논리 연산자: &&(and 그리고), ||(or 또는), !(not 부정)
        
        int x = 2;
        int y = 3;
        
        boolean b1 = (x != y);
        System.out.println(b1);
        
        boolean b2 = (x > 0) && (x < 10);
        System.out.println(b2);

    }

}
