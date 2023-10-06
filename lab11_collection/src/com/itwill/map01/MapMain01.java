package com.itwill.map01;

import java.util.HashMap;
import java.util.Set;

/*
 * Map<K, V>
 * |__ HashMap<K, V>, TreeMap<K, V>, ...
 * 
 * Map<K, V>: 키(Key)와 값(Value)의 쌍으로 구성된 데이터를 저장하는 자료 구조.
 * 1. Key: 중복된 값을 가질 수 없음. 하나의 값을 찾기 위한 인덱스와 비슷한 역할.
 *    - 데이터를 저장/검색/수정/삭제할 때 값을 찾기 위한 용도.
 *    - 연속된 값을 가질 필요는 없음.
 * 2. Value: 중복된 값을 가질 수 있음.
 * 
 * HashMap<K, V>: Key를 기준으로 검색을 빠르게 할 수 있는 Map.
 * TreeMap<K, V>: Key를 기준으로 정렬을 빠르게 할 수 있는 Map.
 * 
 */

public class MapMain01 {

    public static void main(String[] args) {
        // 정수를 Key로, 문자열을 Value로 하는 HashMap을 선언, 생성.
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println(map);
        System.out.println("size=" + map.size());
        
        // map에 key-value 데이터를 저장: put(key, value)
        map.put(1, "홍길동");
        System.out.println(map);
        System.out.println("size=" + map.size());
        
        map.put(10, "오쌤");
        System.out.println(map);
        
        map.put(5, "gildong");
        System.out.println(map);
        
        // map에 저장된 값(value)를 찾는 메서드: get(key)
        String value = map.get(1); // map에 저장된 key가 있는 경우 -> value를 리턴.
        System.out.println(value);
        
        value = map.get(100); // map에 저장된 key가 없는 경우 -> null을 리턴.
        System.out.println(value);
        
        // getOrDefault(key, defaultValue)
        System.out.println(map.getOrDefault(5, "무명씨")); // key가 있는 경우 -> value를 찾아서 리턴.
        System.out.println(map.getOrDefault(500, "무명씨")); // key가 없는 경우 -> 아규먼트로 전달한 기본값을 리턴.
        
        // map에 저장된 데이터 삭제: remove(key)
        // 1) key가 있는 경우, key-value를 map에서 삭제하고, 삭제한 value를 리턴.
        // 2) key가 없는 경우, null을 리턴.
        value = map.remove(5);
        System.out.println("삭제된 값 = " + value);
        System.out.println(map);
        
        value = map.remove(100);
        System.out.println("삭제된 값 = " + value);
        System.out.println(map);
        
        // put(key, value):
        // 1) key가 없는 경우, key-value 데이터를 map에 저장.
        // 2) key가 있는 경우, 키에 매핑되어 있는 값(value)를 변경.
        map.put(10, "허균");
        System.out.println(map);
        
        // map과 반복문
        Set<Integer> kset = map.keySet(); // map에서 key들의 집합을 찾음.
        for (Integer k : kset) {
            System.out.println(k + " = " + map.get(k));
        }
        
    }

}
