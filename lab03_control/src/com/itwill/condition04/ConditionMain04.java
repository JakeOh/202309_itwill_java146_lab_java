package com.itwill.condition04;

public class ConditionMain04 {

    public static void main(String[] args) {
        // 삼항 연산자: if-else 구문을 간단히 만든 문법.
        
        int x = 1;
        int y = 5;
        
        // x와 y 중에서 더 큰 값을 big 변수에 저장.
        int big;
        if (x > y) {
            big = x;
        } else {
            big = y;
        }
        System.out.println(big);
        
        // (조건식) ? (조건식을 만족할 때 채택할 값) : (조건식을 만족하지 못할 때 채택할 값)
        int big2 = (x > y) ? x : y;
        System.out.println(big2);
        
    }

}
