package com.itwill.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMain02 {

    public List<Object> filter(List<Object> list, MyFilter filter) {
        List<Object> result = new ArrayList<>();
        
        for (Object x : list) {
            if (filter.test(x)) {
                result.add(x);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // LambdaMain02 타입 객체 생성
        LambdaMain02 app = new LambdaMain02();
        
        List<Object> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(numbers);
        
        // numbers의 원소들 중에서 짝수들로만 이루어진 리스트를 만들고 출력.
        // 익명 클래스 사용.
        List<Object> evens = app.filter(numbers, new MyFilter() {
            @Override
            public boolean test(Object x) {
                return (Integer) x % 2 == 0;
            }
        });
        System.out.println(evens);
        
        // numbers의 원소들 중에서 홀수들로만 이루어진 리스트를 만들고 출력.
        // 람다 표현식을 사용.
        List<Object> odds = app.filter(numbers, (x) -> (Integer) x % 2 == 1);
        System.out.println(odds);

    }

}
