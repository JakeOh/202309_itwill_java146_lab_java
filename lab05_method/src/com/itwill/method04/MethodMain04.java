package com.itwill.method04;

public class MethodMain04 {

    public static void main(String[] args) {
        // 메서드 오버로딩(method overloading):
        // 메서드의 파라미터가 다르면 같은 이름으로 메서드를 여러개 선언(정의)할 수 있음.
        // (주의) 파리미터는 동일하고 리턴 타입만 다르게는 오버로딩할 수 없음 -> 컴파일 에러!
        
        System.out.println("문자열");
        System.out.println(100);
        System.out.println();
        newLine();
        newLine(2);
        System.out.println(1.0);

    } // end main
    
    /**
     * 콘솔에 빈 줄 하나를 출력.
     */
    public static void newLine() {
        System.out.println();
    }
    
    /**
     * 아규먼트로 전달받은 숫자만큼 콘솔에 빈 줄을 출력.
     * 
     * @param n 출력할 빈 줄의 개수. 양의 정수. 0 또는 음수인 경우에는 아무것도 출력하지 않음.
     */
    public static void newLine(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }

} // end class
