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
    
    /**
     * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합계를 리턴.
     * 
     * @param array int[]. 정수들의 배열.
     * @return array의 모든 원소들의 합.
     */
    public static int sum(int[] array) {
        int total = 0;
        for (int x : array) {
            total += x;
        }
        
        return total;
    }

    /**
     * 정수들의 1차원 배열 array의 원소들의 평균을 리턴.
     * 
     * @param array 정수들의 1차원 배열.
     * @return 원소들의 평균.
     */
    public static double mean(int[] array) {
        return (double) sum(array) / array.length;
    }
    
    /**
     * 정수들의 배열의 array의 원소들 중 최댓값을 찾아서 리턴.
     * 
     * @param array 정수(int)들의 배열.
     * @return 최댓값.
     */
    public static int max(int[] array) {
        int max = array[0];
        for (int x : array) {
            if (x > max) {
                max = x;
            }
        }
        
        return max;
    }
    
    /**
     * 정수들의 배열 array의 원소들 중 최솟값을 리턴.
     * 
     * @param array 최솟값을 찾을 정수들의 배열.
     * @return array의 최솟값.
     */
    public static int min(int[] array) {
        int min = array[0];
        for (int x : array) {
            min = (x < min) ? x : min;
        }
        
        return min;
    }
    
}
