package com.itwill.method07;

public class MethodMain07 {

    public static void main(String[] args) {
        // 가변 길이 인수(variable-length argument):
        // 메서드를 호출할 때 아규먼트의 개수가 정해져 있지 않은 경우.

        System.out.printf("안녕하세요.\n");
        System.out.printf("안녕하세요, 저는 %s입니다.\n", "오쌤");
        System.out.printf("%s은(는) %d살입니다.\n", "오쌤", 16);
        
        int sum = addAll(); // argument 0개
        System.out.println("sum = " + sum);
        
        sum = addAll(1); // argument 1개
        System.out.println("sum = " + sum);
        
        sum = addAll(1, 2, 3, 4); // argument 4개
        System.out.println("sum = " + sum);
        
        int result = calculate("");
        System.out.println("result = " + result);
        
        result = calculate("+", 1, 2, 3);
        System.out.println("result = " + result);
        
        result = calculate("*", 1, 2, 3, 4, 5);
        System.out.println("result = " + result);
        
    }
    
    // 가변 인수를 갖는 메서드를 선언(정의)하는 방법:
    // 가변 인수를 저장하는 파라미터는 "변수타입... 변수이름" 형식으로 선언.
    // 가변 인수는 메서드 안에서는 배열처럼 취급.
    // (주의 1) 가변 인수를 저장하는 파라미터는 반드시 가장 마지막 파라미터여야 함.
    // (주의 2) 가변 인수를 저장하는 파라미터는 2개 이상 있을 수 없음.
    // 가변 인수를 갖는 메서드를 사용할 때는 전달하는 아규먼트 개수에 제한이 없음.
    // - 가변 인수 위치에 아규먼트를 전달하지 않아도 됨.
    
    /**
     * 아규먼트로 전달받은 모든 정수들을 다 더해서 리턴.
     * 아규먼트가 없는 경우에는 0을 리턴.
     * 
     * @param args 더해 줄 정수들. 개수 제한 없음.
     * @return 0 또는 args들의 합.
     */
    public static int addAll(int... args) {
        int result = 0;
        
        // 가변 인수 args는 배열처럼 생각!
        for (int x : args) {
            result += x;
        }
        
        return result;
    }
    
    /**
     * calculate
     * op의 값이 "+"인 경우, 가변 인수 values의 합을 리턴. values가 없으면 0 리턴.
     * op의 값이 "*"인 경우, 가변 인수 values의 곱을 리턴. values가 없으면 1 리턴.
     * op의 값이 "+"나 "*"가 아닌 경우에는 0을 리턴.
     * 
     * @param op 연산자. "+" 또는 "*".
     * @param values 가변 인수. 정수(int).
     * @return values의 합 또는 곱.
     */
    public static int calculate(String op, int... values) {
        int result = 0;
        
        switch (op) {
        case "+":
            for (int x : values) {
                result += x;
            }
            break;
        case "*":
            result = 1;
            for (int x : values) {
                result *= x;
            }
            break;
        }
        
        return result;
    }

}
