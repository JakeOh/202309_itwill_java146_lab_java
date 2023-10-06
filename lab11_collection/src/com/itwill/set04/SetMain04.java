package com.itwill.set04;

import java.util.HashSet;

public class SetMain04 {

    public static void main(String[] args) {
        // Score 타입 객체를 저장할 수 있는 HashSet을 선언, 생성.
        HashSet<Score> scores = new HashSet<Score>();
        
        // set에 3개의 Score 객체 저장.
        Score s1 = new Score();
        scores.add(s1);
        System.out.println(scores);
        
        Score s2 = new Score(0, 0, 0);
        scores.add(s2);
        System.out.println(scores);

        Score s3 = new Score(100, 90, 80);
        scores.add(s3);
        System.out.println(scores);
    }

}
