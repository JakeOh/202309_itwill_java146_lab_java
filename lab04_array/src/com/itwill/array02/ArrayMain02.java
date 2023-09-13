package com.itwill.array02;

import java.util.Random;

public class ArrayMain02 {

    public static void main(String[] args) {
        // 시험 점수를 저장하는 배열에 점수들을 저장하고, 
        // 배열의 내용을 출력, 총점 계산 출력, 평균 계산 출력.
        
        Random random = new Random();
        
        // 1. 정수(int) 10개를 저장할 수 있는 배열(scores)을 선언.
        int[] scores = new int[10];
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        //-> 정수 배열을 만들면 모두 0으로 채워진 배열이 만들어짐.
        System.out.println();
        
        // 2. for 구문을 이용해서 배열 scores에 정수 10개를 저장.
        // 0 이상 10 이하(11 미만)의 정수 난수를 저장.
        for (int i = 0; i < scores.length; i++) {
            scores[i] = random.nextInt(11); // random.nextInt(0, 11);
        }
        
        // 3. 배열에 저장된 점수들을 한 줄에 출력.
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();
        
        for (int x : scores) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        // 4. 배열의 모든 점수들의 합계를 계산하고 출력.
        int sum = 0; // 배열에 있는 점수들의 합계를 저장할 변수.
        for (int x : scores) {
            sum += x;
        }
        System.out.println("sum = " + sum);
        
        // 5. 평균(double)을 계산하고 출력.
        double mean = (double) sum / scores.length;
        System.out.println("mean = " + mean);

    }

}
