package com.itwill.class04;

public class AppMain04 {

    public static void main(String[] args) {
        // Score 객체를 기본 생성자를 사용해서 생성.
        Score score1 = new Score();
        System.out.println("score1 = " + score1);
        System.out.println("score1 국어 = " + score1.korean);
        System.out.println("score1 총점 = " + score1.getTotal());
        System.out.println("score1 평균 = " + score1.getMean());

        // Score 객체를 아규먼트를 갖는 생성자를 사용해서 생성.
        Score score2 = new Score(100, 50, 70);
        System.out.println("score2 = " + score2);
        System.out.println("score2 국어 = " + score2.korean);
        System.out.println("score2 총점 = " + score2.getTotal());
        System.out.println("score2 평균 = " + score2.getMean());
        
        // 기본 생성자를 사용해서 Student 타입 객체 생성.
        Student stu1 = new Student();
        System.out.println("stu1 = " + stu1);
        System.out.println("stu1 번호 = " + stu1.studentNo);
        System.out.println("stu1 이름 = " + stu1.studentName);
        System.out.println("stu1 점수 = " + stu1.score);
        
        stu1.studentName = "홍길동";
        System.out.println("stu1 이름 = " + stu1.studentName);
        
        stu1.score = score1;
        System.out.println("stu1 국어 = " + stu1.score.korean);
        
        // argument 3개를 갖는 생성자를 사용해서 Student 타입 객체 생성.
        Student stu2 = new Student(100, "철수", score2);
        System.out.println("stu2 = " + stu2);
        
        Student stu3 = new Student(101, "오쌤", new Score(50, 50, 70));
        System.out.println("stu3 = " + stu3);
    }

}
