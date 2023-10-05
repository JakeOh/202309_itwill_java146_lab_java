package com.itwill.list01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Collection<E>
 * |__ List<E>
 *     |__ ArrayList<E>, LinkedList<E>, ...
 * 
 * 리스트(list)의 특징:
 * 1. 값들을 저장하는 순서가 중요 - 인덱스(index)를 가지고 있음.
 * 2. 값들을 저장할 때마다 인덱스는 자동으로 증가 - 저장 공간이 자동으로 증가.
 * 3. 리스트 중간에 있는 값을 삭제하면 인덱스가 자동으로 재배열됨.
 * 4. 같은 값들을 여러번 저장할 수 있음 - Set<E>과 다른 점.
 * 5. List<E>에서 <E>는 리스트가 저장하는 원소(element)의 데이터 타입을 의미
 *    (주의) 리스트는 클래스 타입의 객체만 저장할 수 있음. 기본 타입 데이터는 저장할 수 없음!
 *    
 * ArrayList<E>의 특징:
 * 1. 배열(array)을 이용한 리스트.
 * 2. 데이터를 저장(add), 삭제(remove) 속도가 느림.
 * 3. 데이터 검색(get) 속도 빠름.
 * 
 * LinkedList<E>의 특징:
 * 1. linked list 알고리즘을 이용한 리스트.
 * 2. 데이터 저장, 삭제 속도가 빠름.
 * 3. 데이터 검색 속도 느림.
 */

public class ListMain01 {

    public static void main(String[] args) {
        // 문자열을 저장하는 ArrayList를 생성
        ArrayList<String> languages = new ArrayList<>();
        System.out.println(languages); //-> toString 메서드가 override되어 있음.
        
        System.out.println("size=" + languages.size()); //-> 리스트 크기(원소 개수)
        
        // 리스트에 원소 추가
        languages.add("Java");
        languages.add("SQL");
        System.out.println(languages);
        System.out.println("size=" + languages.size());

        // 리스트의 특정 인덱스에 있는 원소 값을 읽음
        System.out.println(languages.get(1));
        
        // for 반복문을 사용해서 리스트의 원소들을 모두 출력.
        for (int i = 0; i < languages.size(); i++) {
            System.out.print(languages.get(i) + ", ");
        }
        System.out.println();
        
        // 향상된 for 구문을 사용한 리스트 원소 출력
        for (String s : languages) {
            System.out.print(s + ", ");
        }
        System.out.println();
        
        // 리스트의 원소 삭제
        languages.remove(0); // remove(int index)
        System.out.println(languages);
        
        languages.remove("SQL"); // remove(Object element)
        System.out.println(languages);
        
        List<String> list = Arrays.asList("Java", "SQL", "Java", "HTML");
        ArrayList<String> alist = new ArrayList<String>(list);
        System.out.println(alist);
        boolean result = alist.remove("Java");
        System.out.println("result=" + result);
        System.out.println(alist);
        
        result = alist.remove("java");
        System.out.println("result=" + result);
        System.out.println(alist);
        
    }

}
