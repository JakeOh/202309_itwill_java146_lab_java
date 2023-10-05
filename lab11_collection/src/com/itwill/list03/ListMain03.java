package com.itwill.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMain03 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("java", "sql", "html", "css", "javascript",
                "servlet", "jsp", "spring");
        
        // 1. names에서 5글자 이상인 문자열을 대문자로 변환해서 저장하는 ArrayList를 만들고 출력.
        // -> [JAVASCRIPT, SERVLET, SPRING]
        ArrayList<String> words = new ArrayList<String>();
        for (String s : names) {
            if (s.length() >= 5) {
                words.add(s.toUpperCase());
            }
        }
        System.out.println(words);
        
        // 2. names에 저장된 문자열의 글자수들을 저장하는 ArrayList를 만들고 출력.
        // -> [4, 3, 4, 3, 10, 7, 3, 6]
        ArrayList<Integer> wordLengths = new ArrayList<Integer>();
        for (String s : names) {
            wordLengths.add(s.length());
        }
        System.out.println(wordLengths);
        
        List<Integer> codes = Arrays.asList(0, 1, 0, 1, 1, 0);
        
        // codes의 원소가 0이면 "남성", 1이면 "여성"을 저장하는 ArrayList를 만들고 출력.
        ArrayList<String> genders = new ArrayList<String>();
        for (Integer n : codes) {
            genders.add((n == 0) ? "남성" : "여성");
//            if (n == 0) {
//                genders.add("남성");
//            } else {
//                genders.add("여성");
//            }
        }
        System.out.println(genders);
        
    }

}
