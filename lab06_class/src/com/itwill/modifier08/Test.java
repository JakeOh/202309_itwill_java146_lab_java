package com.itwill.modifier08;

public class Test {
    int instanceVar; // 인스턴스 필드
    static int staticVar; // static 필드

    // 인스턴스 메서드
    public void printVariables() {
        System.out.println("--- 인스턴스 메서드 ---");
        System.out.println("instanceVar = " + instanceVar); // this.instanceVar
        System.out.println("staticVar = " + staticVar); // Test.staticVar
        System.out.println("-----------------------");
    }
    
    // static 메서드
    public static void printVariables2() {
        System.out.println("--- static 메서드 ---");
        //System.out.println(instanceVar); //-> static 메서드는 인스턴스 멤버를 사용할 수 없다!
        System.out.println("staticVar = " + staticVar);
        System.out.println("---------------------");
    }
}
