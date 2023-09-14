package com.itwill.array06;

public class ArrayMain06 {

    public static void main(String[] args) {
        // 문자열 1차원 배열
        String[] newJeans = {"혜인", "해린", "민지", "하니", "다니엘"};
        String[] bts = {"정국", "뷔", "RM", "지민", "슈가", "제이홉", "진"};
        
        // 문자열 2차원 배열
        String[][] idols = {newJeans, bts}; // { {"", "", ...}, {"", "", ...} }
        
        // 향상된 for 구문
        for (String[] group : idols) {
            for (String member : group) {
                System.out.print(member + " ");
            }
            System.out.println();
        }
        
        System.out.println("----------");
        for (int i = 0; i < idols.length; i++) {
            for (int j = 0; j < idols[i].length; j++) {
                System.out.print(idols[i][j] + " ");
            }
            System.out.println();
        }

    }

}
