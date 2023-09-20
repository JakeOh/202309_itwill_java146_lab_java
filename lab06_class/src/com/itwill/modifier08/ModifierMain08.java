package com.itwill.modifier08;

// access 수식어(private, protected, public)는 지역 변수에는 사용할 수 없음.
// final 수식어: 클래스, 클래스의 멤버(필드, 생성자, 메서드), 지역 변수를 수식.
// final의 의미: 변경할 수 없는.
// final 필드/지역변수는 초기화된 값을 변경할 수 없는 변수. 상수(constant).

public final class ModifierMain08 { // final 클래스
    private final String s = "hello"; // final 멤버
    
    public static void main(String[] args) {
        final int x = 1; // final 지역 변수
        //x = 2; //-> 컴파일 에러. final 지역 변수는 새로운 값을 할당(저장)할 수 없다.
    }

}
