package com.itwill.map01;

import java.util.HashMap;

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

    }

}
