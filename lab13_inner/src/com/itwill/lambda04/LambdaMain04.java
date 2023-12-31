package com.itwill.lambda04;

import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {

    public static void main(String[] args) {
        // 사원들의 리스트: Employee를 원소로 갖는 리스트를 선언, 초기화.
        List<Employee> employees = Arrays.asList(
                new Employee(100, "강동균", "개발1팀", "사원", 1_000),
                new Employee(101, "심채원", "개발2팀", "대리", 900),
                new Employee(200, "김연수", "개발1팀", "대리", 1_100),
                new Employee(201, "임유정", "개발2팀", "과장", 2_000),
                new Employee(300, "박선희", "인사팀", "대리", 1_500),
                new Employee(301, "권오중", "인사팀", "사원", 700)
        );
        
        // 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
        System.out.println("----- Ex1. -----");
//        for (Employee e : employees) {
//            System.out.println(e);
//        }
//        employees.forEach((x) -> System.out.println(x));
        employees.forEach(System.out::println);
        
        // 2. 개발팀(1,2팀)에서 일하는 직원들의 급여 합계를 출력.
        System.out.println("----- Ex2. -----");
        double sum = 0; // 급여의 합계를 저장할 변수
        int count = 0; // 개발팀의 직원수를 저장할 변수
        for (Employee e : employees) {
            if (e.getDept().contains("개발")) {
                // e.getDept().equals("개발1팀") || e.getDept().equals("개발2팀")
                sum += e.getSalary();
                count++;
            }
        }
        System.out.println("sum = " + sum + ", count = " + count);
        
        sum = employees.stream()
                .filter((x) -> x.getDept().contains("개발")) // 필터
                .mapToDouble((x) -> x.getSalary()) // 매퍼(변환기)
                .sum(); // 집계 메서드
        System.out.println("sum = " + sum);
        
        // 3. 개발팀에서 일하는 직원들의 급여 평균을 출력.
        System.out.println("----- Ex3. -----");
        double mean = sum / count;
        System.out.println("mean = " + mean);
        
        mean = employees.stream()
                .filter((x) -> x.getDept().contains("개발")) // 필터
//                .mapToDouble((x) -> x.getSalary()) // 매퍼
                .mapToDouble(Employee::getSalary)
                .average() // 집계 메서드
                .orElseThrow();
        System.out.println("mean = " + mean);
        
        // 4. 직급이 "사원"인 직원들의 급여 합계를 출력.
        System.out.println("----- Ex4. -----");
        sum = employees.stream()
                .filter((x) -> x.getEmpTitle().equals("사원"))
                .mapToDouble(Employee::getSalary) // (x) -> x.getSalary()
                .sum();
        System.out.println("sum = " + sum);
        
        // 5. 직급이 "사원"인 직원들의 급여 평균을 출력.
        System.out.println("----- Ex5. -----");
        mean = employees.stream()
                .filter((x) -> x.getEmpTitle().equals("사원"))
                .mapToDouble(Employee::getSalary) // (x) -> x.getSalary()
                .average()
                .orElseThrow();
        System.out.println("mean = " + mean);
        
        // 6. 급여가 1_000을 초과하는 직원들의 정보를 한 줄에 한 명씩 출력.
        System.out.println("----- Ex6. -----");
//        for (Employee e : employees) {
//            if (e.getSalary() > 1_000) {
//                System.out.println(e);
//            }
//        }
        employees.stream()
                .filter((x) -> x.getSalary() > 1000)
                .forEach(System.out::println); // (x) -> System.out.println(x)
        
        // 7. 개발1팀 직원들의 급여를 10% 인상하고, 인상한 급여의 평균을 출력.
        System.out.println("----- Ex7. -----");
        sum = 0; // 인상된 급여들의 합계를 저장할 변수
        count = 0; // 직원수를 저장할 변수
        for (Employee e : employees) {
            if (e.getDept().equals("개발1팀")) {
                sum += e.getSalary() * 1.1;
                count++;
            }
        }
        mean = sum / count; // 인상된 급여들의 평균
        System.out.println("mean = " + mean);
        
        mean = employees.stream()
                .filter((x) -> x.getDept().equals("개발1팀"))
                .mapToDouble((x) -> x.getSalary() * 1.1)
                .average()
                .orElseThrow();
        System.out.println("mean = " + mean);
        
        // 8. 직급 "대리"는 몇 명?
        System.out.println("----- Ex8. -----");
        count = 0; // 대리 숫자를 저장할 변수
        for (Employee e : employees) {
            if (e.getEmpTitle().equals("대리")) {
                count++;
            }
        }
        System.out.println("count = " + count);
        
        long count2 = employees.stream()
                .filter((x) -> x.getEmpTitle().equals("대리"))
                .count();
        System.out.println("count = " + count2);

    }

}
