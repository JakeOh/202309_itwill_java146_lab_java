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

        int maxIndex = indexOfMax(scores);
        System.out.println("최댓값 인덱스 = " + maxIndex);
        
        int minIndex = indexOfMin(scores);
        System.out.println("최솟값 인덱스 = " + minIndex);
        
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
//        return array[indexOfMax(array)];
        
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
    
    /**
     * 정수들의 1차원 배열 array에서 최댓값의 위치(인덱스)를 찾아서 리턴.
     * 만약 최댓값이 2개 이상인 경우 첫번째 최댓값의 인덱스를 리턴.
     * 
     * @param array 정수들의 배열.
     * @return 최댓값의 인덱스.
     */
    public static int indexOfMax(int[] array) {
        int max = array[0]; // 최댓값을 저장할 변수
        int index = 0; // 배열 원소의 인덱스를 저장할 변수
        int maxIndex = 0; // 최댓값의 인덱스를 저장할 변수
        for (int x : array) {
            if (x > max) {
                max = x;
                maxIndex = index;
            }
            
            index++;
        }
        
        return maxIndex;
    }
    
    /**
     * 정수들의 1차원 배열 array에서 최솟값의 인덱스를 리턴.
     * 만약 최솟값이 2개 이상이면, 첫번째 최솟값의 인덱스를 리턴.
     * 
     * @param array 정수들의 배열.
     * @return array의 최솟값의 인덱스.
     */
    public static int indexOfMin(int[] array) {
        int min = array[0]; // 최솟값을 저장할 변수.
        int minIndex = 0; // 최솟값의 인덱스를 저장할 변수.
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        
        return minIndex;
    }
    
}
