package com.itwill.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeEx {

    public static void main(String[] args) {
        // Java 8 버전부터 java.time 패키지의 날짜/시간 클래스
        
        LocalDate today = LocalDate.now(); // 현재 날짜
        System.out.println(today); // today.toString()
        System.out.println(today.getYear()); //-> 연도
        System.out.println(today.getMonthValue()); //-> 달을 int로 리턴.
        System.out.println(today.getMonth()); //-> Month 타입의 enum 값을 리턴.
        System.out.println(today.getDayOfMonth()); //-> 달에서 몇번째 날인지 int로 리턴.
        System.out.println(today.getDayOfYear()); //-> 연도에서 몇번째 날인지 int로 리턴.
        System.out.println(today.getDayOfWeek()); //-> 요일을 DayOfWeek 타입의 enum 값을 리턴.
        System.out.println(today.plusDays(1)); //-> 내일
        System.out.println(today.plusMonths(1));
        System.out.println(today.minusDays(1)); //-> 어제
        
        LocalDate date = LocalDate.of(2024, 3, 11);
        System.out.println(date);
        
        LocalDateTime now = LocalDateTime.now(); // 현재 날짜와 시간
        System.out.println(now);
        
        LocalDateTime time = LocalDateTime.of(2023, 12, 31, 0, 0);
        System.out.println(time);
    }

}
