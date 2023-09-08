package com.itwill.variable03;

public class VariableMain03 {

    public static void main(String[] args) {
        // 변수를 사용할 때 주의할 점:
        // 같은 이름으로 변수를 2번 이상 선언할 수 없음.
        int x = 1;
        System.out.println(x);
        
        //int x = 2;  //-> 같은 이름으로 변수를 선언하면 에러.
        x = 2; // 이미 선언된 변수의 값을 다른 값으로 변경(재할당).
        System.out.println(x);

    }

}
