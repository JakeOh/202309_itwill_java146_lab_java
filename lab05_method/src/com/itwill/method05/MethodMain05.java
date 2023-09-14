package com.itwill.method05;

public class MethodMain05 {

    public static void main(String[] args) {
        // 메서드 작성 연습:

        int[] scores = {70, 60, 100, 50, 81};
        
        int sum = sum(scores);
        System.out.println("총점 = " + sum);
        
        double avg = mean(scores);
        System.out.println("평균 = " + avg);
        
        int max = max(scores);
        System.out.println("최댓값 = " + max);
        
        int min = min(scores);
        System.out.println("최솟값 = " + min);

    }

}
