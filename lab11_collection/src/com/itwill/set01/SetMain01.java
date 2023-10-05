package com.itwill.set01;

import java.util.TreeSet;

/*
 * Collection<E>
 * |__ List<E>
 *     |__ ArrayList<E>, LinkedList<E>, ...
 * 
 * Collection<E>
 * |__ Set<E>
 *     |__ HashSet<E>, TreeSet<E>, ...
 *     
 * Set<E> 특징:
 * 1. 중복된 값을 저장하지 않음. (예) {1, 2, 2, 3, 3, 3} = {1, 2, 3}
 * 2. 저장하는 순서가 중요하지 않음 - 인덱스가 없음. (예) {1, 2} = {2, 1}
 * 
 * HashSet<E>: Hash 알고리즘(검색을 빠르게 할 수 있는 알고리즘)을 사용한 Set<E>.
 * TreeSet<E>: Tree 알고리즘(정렬을 빠르게 할 수 있는 알고리즘)을 사용한 Set<E>.
 */

public class SetMain01 {

    public static void main(String[] args) {
        // 정수들을 저장하는 TreeSet 변수 선언, 객체 생성.
        TreeSet<Integer> set = new TreeSet<>();
        System.out.println(set);
        System.out.println("size=" + set.size());
        
        // Set에 원소들을 저장.
        set.add(11);
        System.out.println(set);
        
        set.add(2);
        System.out.println(set);
        
        set.add(15);
        System.out.println(set);
        
        set.add(11);
        System.out.println(set);
        
        // Set<E> get(int index) 메서드를 제공하지 않음.
        // -> for 구문은 사용할 수 없지만, 향상된 for 구문은 사용 가능.
        for (Integer n : set) {
            System.out.print(n + ", ");
        }
        System.out.println();

        // List<E>는 remove(int index), remove(Object element) 메서드를 제공.
        // Set<E>은 remove(Object element) 메서드만 제공.
        set.remove(15);
        System.out.println(set);
        
    }

}
