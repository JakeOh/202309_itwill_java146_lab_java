package com.itwill.condition05;

public class ConditionMain05 {

    public static void main(String[] args) {
        // 삼항 연산자 연습
        int genderCode = 2;
        String gender = "";
        
        // genderCode의 값이 1이면 gender에 "남성"을,
        // genderCode의 값이 2이면 gender에 "여성"을 저장.
        // genderCode의 값은 1 또는 2만 가능하다고 가정.
        if (genderCode == 1) {
            gender = "남성";
        } else {
            gender = "여성";
        }
        System.out.println(gender);
        
        gender = (genderCode == 1) ? "남성" : "여성";
        System.out.println(gender);
        
        // 짝수, 홀수 구분:
        // number가 짝수이면 evenOrOdd에 "짝수"를 저장,
        // number가 홀수이면 evenOrOdd에 "홀수"를 저장.
        int number = 911;
        String evenOrOdd = "";
        
        if (number % 2 == 0) {
            evenOrOdd = "짝수";
        } else {
            evenOrOdd = "홀수";
        }
        System.out.println(evenOrOdd);
        
        evenOrOdd = (number % 2 == 0) ? "짝수" : "홀수";
        System.out.println(evenOrOdd);

    }

}
