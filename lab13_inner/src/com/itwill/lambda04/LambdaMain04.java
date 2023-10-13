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
        // 2. 개발팀(1,2팀)에서 일하는 직원들의 급여 합계를 출력.
        // 3. 개발팀에서 일하는 직원들의 급여 평균을 출력.
        // 4. 직급이 "사원"인 직원들의 급여 합계를 출력.
        // 5. 직급이 "사원"인 직원들의 급여 평균을 출력.
        // 6. 급여가 1_000을 초과하는 직원들의 정보를 한 줄에 한 명씩 출력.
        // 7. 개발1팀 직원들의 급여를 10% 인상하고, 인상한 급여의 평균을 출력.
        // 8. 직급 "대리"는 몇 명?

    }

}
