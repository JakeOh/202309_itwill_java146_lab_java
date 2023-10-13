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
    
    public List<Object> map(List<Object> list, MyMapper mapper) {
        List<Object> result = new ArrayList<>();
        
        for (Object x : list) {
            result.add(mapper.transform(x));
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

        List<Object> languages = Arrays.asList("Java", "SQL", "JavaScript", "HTML", "Servlet");
        System.out.println(languages);
        
        // languages의 원소들 중에서 5글자 이상인 문자열들로 이루어진 리스트를 만들고 출력.
//        List<Object> result = app.filter(languages, new MyFilter() {
//            @Override
//            public boolean test(Object x) {
//                return ((String) x).length() >= 5;
//            }
//        });
        List<Object> result = app.filter(languages, (x) -> ((String) x).length() >= 5);
        System.out.println(result);
        
        // 리스트 numbers의 원소가 짝수이면 "even", 홀수이면 "odd"를 저장하는 리스트를 만들고 출력
        List<Object> evenOrOdd = app.map(numbers, new MyMapper() {
            @Override
            public Object transform(Object x) {
//                if ((Integer) x % 2 == 0) {
//                    return "even";
//                } else {
//                    return "odd";
//                }
                return ((Integer) x % 2 == 0) ? "even" : "odd";
            }
        });
        System.out.println(evenOrOdd);
        
//        List<Object> evenOrOdd2 = app.map(numbers, (x) -> {
//            if ((Integer) x % 2 == 0) {
//                return "짝수";
//            } else {
//                return "홀수";
//            }
//        });
        List<Object> evenOrOdd2 = app.map(numbers, 
                (x) -> ((Integer) x % 2 == 0) ? "even" : "odd");
        System.out.println(evenOrOdd2);
        
        // numbers의 원소들의 제곱을 저장하는 리스트를 만들고 출력.
        List<Object> squares = app.map(numbers, (x) -> (Integer) x * (Integer) x);
        System.out.println(squares);
        
        // languages의 문자열들을 모두 대문자로 변환한 리스트를 만들고 출력.
        List<Object> upperCases = app.map(languages, (x) -> ((String) x).toUpperCase());
        System.out.println(upperCases);
    }

}
