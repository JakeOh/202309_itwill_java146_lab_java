package com.itwill.condition02;

public class ConditionMain02 {

    public static void main(String[] args) {
        // 중첩 조건문: if 또는 else 블록 안에 또다른 조건문이 있는 경우.
        
        double x = -3.14;
        if (x > 0) {
            System.out.println("양수");
        } else {
            if (x < 0) {
                System.out.println("음수");
            } else {
                System.out.println("zero");
            }
        }
        
    }

}
