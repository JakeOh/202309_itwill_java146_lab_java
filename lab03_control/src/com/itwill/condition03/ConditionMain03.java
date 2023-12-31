package com.itwill.condition03;

import java.util.Scanner; // java.util 패키지에서 선언된 Scanner 클래스 이름을 사용하기 위해서. 

public class ConditionMain03 {

    public static void main(String[] args) {
        // 키보드에서 입력받은 값을 저장하는 방법:
        // (1) Scanner 타입으로 변수를 선언하고, Scanner 객체를 저장.
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Java 과목 점수 입력>>>");
        // (2) 키보드에서 정수를 입력받아서 int 타입 변수에 저장.
        int java = sc.nextInt();
        
        // SQL 과목의 점수를 입력 받고 변수에 저장.
        System.out.println("SQL 과목 점수 입력>>>");
        int sql = sc.nextInt();
        
        // JavaScript 과목의 점수를 입력 받고 변수에 저장.
        System.out.println("JavaScript 과목 점수 입력>>>");
        int js = sc.nextInt();
        
        // 세 과목(Java, SQL, JavaScript)의 점수를 출력.
        System.out.println("Java 점수: " + java);
        System.out.println("SQL 점수: " + sql);
        System.out.println("JavaScript 점수: " + js);
        
        // 세 과목의 총점을 계산해서 출력.
        int sum = java + sql + js;
        System.out.println("총점: " + sum);
        
        // 세 과목의 평균을 계산해서 출력, 평균값은 소수점 계산이 되어야 함.
        double mean = (double) sum / 3;
        System.out.println("평균: " + mean);
        
        // 세 과목의 평균이 90점 이상이면, "A"
        // 세 과목의 평균이 80점 이상이면, "B"
        // 세 과목의 평균이 70점 이상이면, "C"
        // 그 이외에는 "F"라고 출력.
        if (mean >= 90) {
            System.out.println("A");
        } else if (mean >= 80) {
            System.out.println("B");
        } else if (mean >= 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }
    
        sc.close();
    }

}
