package com.itwill.array05;

public class ArrayMain05 {

    public static void main(String[] args) {
        // 다차원 배열: 배열들을 원소로 갖는 배열.
        // 2차원 배열: 1차원 배열들을 원소로 갖는 배열.
        // 2차원 배열은 인덱스를 2개 갖음.
        
        // 2차원 배열 선언 & 초기화 방법 1:
        // 타입[][] 배열이름 = { { ... }, { ... }, { ... }, ... };
        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7},
                {8, 9, 10, 11, 12}
        };
        
        // 배열 array의 길이?
        System.out.println("array length = " + array.length);
        
        // array[0]의 타입: int[]
        // array[0]의 길이?
        System.out.println("array[0] length = " + array[0].length);
        
        // array[0][0]의 타입: int
        System.out.println(array[0][0]);

    }

}
