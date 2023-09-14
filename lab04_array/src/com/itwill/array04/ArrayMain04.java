package com.itwill.array04;

import java.util.Random;

public class ArrayMain04 {

    public static void main(String[] args) {
        // 정수(int) 5개를 저장할 수 있는 배열 선언 & 초기화:
        int[] array = new int[5];
        
        // 배열에 정수 난수([0, 11))들을 저장:
        Random random = new Random();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(11);
        }
        
        // 배열의 내용을 출력:
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        // 배열 원소들 중 최댓값 찾기:
        int max = array[0]; // 배열의 첫번째 원소를 최댓값이라고 가정.
        for (int x : array) { // array의 원소들을 처음부터 끝까지 반복하면서
            if (x > max) { // 배열에 찾은 값이 최댓값보다 크다면
                max = x; // 최댓값을 배열에서 찾은 값으로 변경.
            }
        }
        System.out.println("max = " + max);

        // 배열의 원소들 중 최솟값 찾기:
        int min = array[0]; // 배열의 첫번째 원소를 최솟값이라고 가정.
        for (int x : array) { // 배열의 원소들을 처음부터 끝까지 반복하면서
            min = (x < min) ? x : min; // 더 작은 값으로 min의 값을 변경.
        }
        System.out.println("min = " + min);
        
    }

}
