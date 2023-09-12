package com.itwill.increase;

public class OperatorMain {

    public static void main(String[] args) {
        // 증가(++), 감소(--) 연산자:
        // 1. 단항 연산자. 변수 앞 또는 뒤에서 사용 가능. (예) ++x, x++
        // 2. 단독으로 사용되는 경우에는, 변수 앞에 있는 것과 변수 뒤에 있는 것이 동일.
        // 3. 다른 연산자와 함께 사용되는 경우에는,
        //    (1) 변수 앞에 있는 경우는, 다른 연산자들보다 먼저 증가/감소 연산이 수행됨.
        //    (2) 변수 뒤에 있는 경우는, 다른 연산들이 끝난 이후에 증가/감소 연산이 수행됨.
        
        int x = 1;
        System.out.println("x = " + x); //-> 1
        
        ++x;
        System.out.println("x = " + x); //-> 2
        
        x++;
        System.out.println("x = " + x); //-> 3
        
        int y = 1;
        System.out.println("y = " + y); //-> y = 1
        
        int result = ++y + 10; // 변수 앞에서 사용된 증가 연산자
        System.out.println("result = " + result); //-> result = 12
        System.out.println("y = " + y); //-> y = 2
        
        int z = 1;
        System.out.println("z = " + z); //-> z = 1
        
        result = z++ + 10; // 변수 뒤에서 사용된 증가 연산자
        System.out.println("result = " + result); //-> result = 11
        System.out.println("z = " + z); //-> z = 2
        
        int n = 1;
        result = n++ + 10 + ++n;
        // 연산 순서:
        // 1) n++ + 10
        //    (1) 덧셈(+): 1 + 10 = 11 -> 1) 연산 결과
        //    (2) 증가(++): n=2
        // 2) 1)의 결과 + ++n = 11 + ++n
        //    (1) 증가(++): n=3
        //    (2) 덧셈(+): 11 + 3 = 14 -> 최종 결과 -> result에 저장.
        System.out.println("result = " + result); //-> result = ?
        System.out.println("n = " + n); //-> n = ?
    }

}
