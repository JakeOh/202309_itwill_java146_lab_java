package com.itwill.map03;

import java.util.HashMap;

public class MapMain03 {

    public static void main(String[] args) {
        // 단어 개수 세기(word counting):
        // 문자열 sentence에 등장하는 단어를 key로 하고 
        // 그 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고 출력.
        // 결과: {땅=2, 바다=1, 사람=1, 하늘=3, sky=2}
        String sentence = "하늘 바다 땅 하늘 땅 사람 하늘 sky sky";
        
        // sentence 문자열을 공백으로 구분해서 단어들로만 이루어진 배열을 만듦.
        String[] words = sentence.split(" ");
        for (String s : words) {
            System.out.print(s + ", ");
        }
        System.out.println();
        
        // "단어(key)-빈도수(value)"를 저장하기 위한 Map을 선언, 생성.
        HashMap<String, Integer> wordCounts = new HashMap<>();
        System.out.println(wordCounts);
        
        // 배열의 원소(단어)들을 하나씩 반복하면서
        for (String w : words) {
            Integer value = wordCounts.get(w);
            if (value == null) {
                // (1) 단어가 Map에 key로 존재하지 않으면, "단어=1"을 Map에 저장.
                wordCounts.put(w, 1);
            } else {
                // (2) 단어가 Map에 key로 존재하면, 
                // key에 해당하는 "value(기존 등장 횟수) + 1" 값을 Map에 저장.
                wordCounts.put(w, value + 1);
            }
            System.out.println(wordCounts);
        }
        
        System.out.println("----------");
        HashMap<String, Integer> wordCounts2 = new HashMap<>();
        System.out.println(wordCounts2);
        for (String w : words) {
            Integer count = wordCounts2.getOrDefault(w, 0);
            wordCounts2.put(w, count + 1);
            System.out.println(wordCounts2);
        }
        
    }

}
