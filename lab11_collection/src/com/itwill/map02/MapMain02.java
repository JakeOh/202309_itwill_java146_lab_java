package com.itwill.map02;

import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

    public static void main(String[] args) {
        // 문자열을 키로 하고, 정수를 값으로 하는 TreeMap을 선언, 생성.
        TreeMap<String, Integer> menu = new TreeMap<>();
        
        // 데이터 저장
        menu.put("짜장면", 8000);
        menu.put("짬뽕", 9000);
        menu.put("볶음밥", 9000);
        
        System.out.println(menu);
        
        Set<String> kset = menu.keySet(); //-> TreeMap에서는 오름차순 정렬된 키들의 집합
        for (String k : kset) {
            System.out.println(k + " : " + menu.get(k));
        }
        
        System.out.println("-----");
        Set<String> kset2 = menu.descendingKeySet(); //-> TreeMap에서 내림차순 정렬된 키들의 집함
        for (String k : kset2) {
            System.out.println(k + "=" + menu.get(k));
        }

    }

}
