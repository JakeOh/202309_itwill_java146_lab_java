package com.itwill.array01;

public class ArrayMain01 {

    public static void main(String[] args) {
        // 배열(array)의 필요성:
        
        // 점수들
        int score1 = 100;
        int score2 = 90;
        int score3 = 85;
        
        // 총점
        int total = score1 + score2 + score3;
        
        // 평균
        double mean = (double) total / 3;
        
        System.out.println("평균 = " + mean);

        // 배열(array): 같은 타입의 데이터 여러개를 하나의 변수 이름으로 저장하기 위한 메모리.
        // 인덱스(index): 배열에 데이터를 저장하거나, 저장된 값을 읽어올 때 사용하는 정수.
        // - 배열에서 데이터가 저장된 위치.
        // - 인덱스는 0부터 시작하는 연속된 정수.
        // - 마지막 인덱스는 (배열 원소 개수 - 1)
        
        // 배열 선언 & 초기화 방법 1:
        // 타입[] 이름 = new 타입[원소 개수];
        int[] scores = new int[3]; // int 3개를 저장할 수 있는 배열을 만듦.
        
        // 배열의 특정 위치(인덱스)에 값을 저장:
        // 배열[인덱스] = 값;
        scores[0] = 100;
        scores[1] = 90;
        scores[2] = 87;
        
        // 배열에 저장된 값을 읽을 때: 배열[인덱스]
        System.out.println("scores[0] = " + scores[0]);
        
        // for 반복문을 사용한 배열 원소 출력:
        // 배열이름.length: 배열의 길이(배열의 원소 개수)를 저장하고 있는 속성.
        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + " : " + scores[i]);
        }
        
        // 배열 선언 & 초기화 방법 2:
        // 배열이 가지고 있는 원소들을 나열하면서 배열을 초기화.
        // 타입[] 이름 = {원소1, 원소2, ...};
        int[] numbers = {1, 3, 5, 7};
        
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        
    }

}
