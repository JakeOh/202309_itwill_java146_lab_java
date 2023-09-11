package com.itwill.condition06;

import java.util.Random; // Random 클래스를 사용하기 위해서.

public class ConditionMain06 {

    public static void main(String[] args) {
        // 조건문, 비교/논리 연산자 연습
        
        // 난수를 생성할 수 있는 Random 타입 변수를 선언, 초기화:
        Random random = new Random();
        
        int java = random.nextInt(101); // 0 이상 101 미만의 정수 난수를 만들고, 변수에 저장.
        System.out.println("Java: " + java);
        
        int sql = random.nextInt(101); // SQL 과목 점수를 난수로 만듦.
        System.out.println("SQL: " + sql);
        
        int js = random.nextInt(101); // JavaScript 과목 점수를 난수로 만듦.
        System.out.println("JavaScript: " + js);
        
        // 세 과목의 점수가 모두 40점 이상이고 평균이 60점 이상이면 합격, 그렇지 않으면 불합격:
        double mean = (double) (java + sql + js) / 3; // 세 과목 평균
        System.out.println("평균: " + mean);
        
        if (java >= 40 && sql >= 40 && js >= 40 && mean >= 60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }
        
        if (java < 40 || sql < 40 || js < 40) {
            System.out.println("fail");
        } else if (mean < 60) {
            System.out.println("fail");
        } else {
            System.out.println("pass");
        }

    }

}
