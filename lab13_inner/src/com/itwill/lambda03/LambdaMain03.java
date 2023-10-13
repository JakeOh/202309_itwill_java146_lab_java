package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LambdaMain03 {

    public static void main(String[] args) {
        // Stream 클래스
        
        Random random = new Random();
        
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(10));
        }
        System.out.println(numbers);
        
        // numbers의 원소들 중에서 짝수들만 저장하는 리스트를 만들고 출력.
        ArrayList<Integer> evens = new ArrayList<>(); // 짝수들을 저장하기 위한 리스트를 생성.
        for (Integer x : numbers) { // numbers의 모든 정수들을 순서대로 순회하면서
            if (x % 2 == 0) { // 리스트에서 선택된 숫자가 짝수이면
                evens.add(x); // evens에 추가.
            }
        }
        System.out.println(evens);
        
        List<Integer> evens2 = numbers.stream().filter((x) -> x % 2 == 0).toList();
        System.out.println(evens2);
        
        // numbers의 원소들 중에서 홀수들만 저장하는 리스트를 만들고 출력.
        List<Integer> odds = numbers.stream().filter((x) -> x % 2 == 1).toList();
        System.out.println(odds);
        
        // numbers의 정수들을 제곱한 값들을 원소로 갖는 리스트를 만들고 출력.
        ArrayList<Integer> squares = new ArrayList<>(); // 제곱들을 저장할 리스트를 생성
        for (Integer x : numbers) { // numbers의 모든 원소들을 순서대로 반복하면서
            squares.add(x * x); // numbers에서 꺼낸 숫자의 제곱을 squares에 추가.
        }
        System.out.println(squares);
        
        List<Integer> squares2 = numbers.stream().map((x) -> x * x).toList();
        System.out.println(squares2);
        
        // numbers의 원소들 중에서 홀수들의 제곱을 저장하는 리스트를 만들고 출력.
        List<Integer> oddSqures = new ArrayList<>();
        for (Integer x : numbers) {
            if (x % 2 == 1) { // filtering
                oddSqures.add(x * x); // mapping -> 수집
            }
        }
        System.out.println(oddSqures);
        
        List<Integer> oddSquares2 = numbers.stream()
                .filter((x) -> x % 2 == 1)
                .map((x) -> x * x)
                .toList();
        System.out.println(oddSquares2);

    }

}
