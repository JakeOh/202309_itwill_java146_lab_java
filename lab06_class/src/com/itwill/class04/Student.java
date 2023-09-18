package com.itwill.class04;

public class Student {
    // 필드
    int studentNo; // 학생 번호
    String studentName; // 학생 이름
    Score score; // 학생 수강(국어/영어/수학) 과목 점수

    // 생성자: 기본 생성자, 아규먼트를 갖는 생성자
    public Student() {}
    
    public Student(int studentNo, String studentName, Score score) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.score = score;
    }
    
    public Student(int studentNo, String studentName, int korean, int english, int math) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.score = new Score(korean, english, math);
    }
    
    // 메서드: 학생의 정보를 출력하는 메서드.
    // 번호, 이름, 국어 점수, 영어 점수, 수학 점수, 총점, 평균을 출력.
    public void info() {
        System.out.println("--- 학생 정보 ---");
        System.out.println("번호: " + studentNo);
        System.out.println("이름: " + studentName);
        if (score != null) {
            System.out.println("국어: " + score.korean);
            System.out.println("영어: " + score.english);
            System.out.println("수학: " + score.math);
            System.out.println("총점: " + score.getTotal());
            System.out.println("평균: " + score.getMean());
        } else {
            System.out.println("점수: null");
        }
    }
    
}
