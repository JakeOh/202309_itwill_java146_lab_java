package com.itwill.thread02;

/*
 * 자바는 다중 상속을 지원하지 않음!
 *   class A extends B, C {} -> 문법 오류
 * 다른 클래스를 이미 상속하는 클래스는 Thread를 상속할 수 없음.
 * 자바는 인터페이스 구현은 개수 제한이 없음.
 *   class A extends B implements C, D {} -> 가능
 * 
 * Thread 사용방법 2:
 * (1) Runnable 인터페이스를 구현하는 클래스를 선언.
 * (2) (1)에서 선언한 클래스에서 run() 메서드를 재정의(override).
 * (3) Thread 생성자를 호출할 때 (2)에서 선언된 클래스의 객체를 아규먼트로 전달.
 * (4) (3)에서 생성된 쓰레드 객체에서 start() 메서드를 호출 -> 쓰레드 실행.
 * 
 */

public class ThreadMain02 {

    public static void main(String[] args) {
        // (1) Runnable 인터페이스를 구현하는 클래스 선언
        class MyRunnable implements Runnable {
            private String name;
            
            public MyRunnable(String name) {
                this.name = name;
            }

            @Override // (2) run 메서드 재정의
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + " - " + name);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            
        }

    }

}
