package com.itwill.inheritance06;

// 2차원 평면에서의 점의 좌표
public class Point {
    // field
    private double x; // x 좌표
    private double y; // y 좌표
    
    // constructor
    public Point() {}
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // Object 클래스에서 toString 메서드는 "패키지.클래스@해시코드" 형식의 문자열를 리턴.
    // Object에서 상속받은 toString을 재정의(override)하게 되면 콘솔 출력 내용을 변경할 수 있음.
    @Override
    public String toString() {
        return "Point(x=" + this.x + ", y=" + this.y + ")";
    }
    
    // Object 클래스에서는 equals 메서드는 실제 힙에 생성된 객체가 같으면 true, 그렇지 않으면 false를 리턴.
    // Object 클래스에서 상속받은 equals 메서드를 재정의(override)하면서 
    // 두 객체의 "같음"을 새로 정의할 수 있음.
    // 예를 들면 2차원 평면의 (x와 y) 좌표값이 같으면 true, 그렇지 않으면 false.
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        
        if (obj instanceof Point) {
            Point pt = (Point) obj;
            result = (this.x == pt.x) && (this.y == pt.y);
        }
        
        return result;
    }
    
    // Object 클래스에서는 hashCode 메서드가 생성된 객체의 주소(참조)값을 리턴.
    // hashCode 메서드는 equals가 true가 되는 두 객체는 같은 해시코드 값을 가져야 함.
    // Object 클래스에서 상속받은 hashCode 메서드를 재정의(override)할 때는,
    // equals가 true이면 해시코드가 같도록 정수(int)를 리턴하면 됨.
    @Override
    public int hashCode() {
        return (int) (x + y);
    }

}
