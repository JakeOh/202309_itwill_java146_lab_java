package com.itwill.loop11;

public class LoopMain11 {

    public static void main(String[] args) {
        // Ex1. 1부터 10까지 자연수들의 합: sum = 1 + 2 + 3 + ... + 10 = 55
        int sum = 0;
        for (int x = 1; x <= 10; x++) {
            sum += x; // sum = sum + x;
            //System.out.println("sum = " + sum);
        }
        System.out.println("sum = " + sum);

        // Ex2. 1부터 100까지 자연수들 중에서 짝수들의 합을 출력:
        // sum = 2 + 4 + 6 + ... + 98 + 100 = ?
        int evenSum = 0;
        for (int x = 1; x <= 100; x++) {
            if (x % 2 == 0) {
                evenSum += x;
            }
        }
        System.out.println("evenSum = " + evenSum);
        
        // Ex3. 1부터 100까지 자연수들 중에서 홀수들의 합을 출력:
        // sum = 1 + 3 + 5 + ... + 97 + 99 = ?
        int oddSum = 0;
        for (int x = 1; x <= 100; x++) {
            if (x % 2 == 1) {
                oddSum += x;
            }
        }
        System.out.println("oddSum = " + oddSum);
        
        // while 연습
        evenSum = 0; // 짝수들의 합을 저장할 변수
        oddSum = 0; // 홀수들의 합을 저장할 변수
        int n = 1;
        while (n <= 100) { // 100 이하의 자연수이면
            if (n % 2 == 0) { // 짝수이면
                evenSum += n;
            } else { // 짝수가 아니면(홀수이면)
                oddSum += n;
            }
            n++;
        }
        System.out.println("evenSum = " + evenSum);
        System.out.println("oddSum = " + oddSum);
        
    }

}
