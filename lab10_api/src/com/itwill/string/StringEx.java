package com.itwill.string;

public class StringEx {

    public static void main(String[] args) {
        // String 클래스의 메서드 사용법
        
        // ex1. 주민번호 문자열에서 성별을 표시하는 위치의 문자를 출력.
        String ssn = "990904-1234567";
        System.out.println(ssn.charAt(7));

        // ex2. 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력.
        // 결과: JavaScript Servlet Spring
        String[] array = {"Java", "SQL", "JavaScript", "HTML", "CSS", "Servlet", "Spring"};
        
        // ex3. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
        // 만약에 "홍길동"이 배열에 없는 경우에는 -1을 출력.
        // 결과: 2
        String[] names = {"오쌤", "John", "홍길동", "Gildong", "홍길동"};
        
        // ex4. 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
        // 결과: TEST test TeSt tEsT
        String[] tests = {"TEST", "test", "TeSt", "tEsT", "테스트"};
    }

}
