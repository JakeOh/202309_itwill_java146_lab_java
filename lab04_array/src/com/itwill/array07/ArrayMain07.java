package com.itwill.array07;

public class ArrayMain07 {

    public static void main(String[] args) {
        // 2차원 배열 선언 & 초기화 방법 2:
        // 타입[][] 배열이름 = new 타입[행의 개수][열의 개수];
        // 행의 개수 - 2차원 배열이 갖는 원소인 1차원 배열의 개수.
        // 열의 개수 - 1차원 배열의 원소의 개수.
        // 행의 개수는 생략하면 안됨! 열의 개수는 생략해도 됨.
        
        // 1. 2차원 배열을 생성할 때, 행과 열의 개수 모두 결정된 경우 -> 직사각형 배열
        int[][] array1 = new int[2][3];
        
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                array1[i][j] = i + j;
            }
        }
        
        for (int[] arr : array1) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        System.out.println("----------");
        
        // 2. 2차원 배열의 원소 개수(행의 개수)는 알지만, 각각의 1차원 배열의 길이는 결정되지 않은 경우:
        int[][] array2 = new int[2][]; // 1차원 배열 2개를 원소로 갖는 2차원 배열.
        array2[0] = new int[3]; // 정수 3개를 갖는 1차원 배열.
        array2[1] = new int[4]; // 정수 4개를 갖는 1차원 배열.
        
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                array2[i][j] = i * j;
            }
        }
        
        for (int[] arr : array2) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        
    }

}
