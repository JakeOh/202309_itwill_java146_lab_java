/*
오라클 함수(function)
1. 단일 행 함수:
   행(row) 하나씩 함수의 아규먼트로 전달되고, 행 마다 하나씩 결과가 리턴되는 함수.
   (예) to_date, to_char, lower, upper, ...
2. 다중 행 함수:
   여러개의 행이 함수의 아규먼트로 전달되고, 하나의 결과가 리턴되는 함수.
   (예) 통계 관련 함수: count, sum, avg, max, min, variance(분산), stddev(표준편차)
*/

-- 단일 행 함수 예 - 모든 행의 값을 소문자로 바꾸기:
select ename, lower(ename), job, lower(job)
from emp;

-- to_char() 함수: 다른 타입의 값을 문자열로 변환. 날짜 -> 문자열.
select hiredate, to_char(hiredate, 'YYYY/MM/DD HH:MI:SS')
from emp;

-- nvl(변수, 값): 변수가 null이면 값을 리턴하고, null이 아니면 원래 값을 리턴.
-- nvl2(변수, 값1, 값2): 변수가 null이 아니면 값1을 리턴하고, null이면 값2를 리턴.
select comm, nvl(comm, -1), nvl2(comm, comm, -1) from emp;

-- 다중 행 함수 예:
-- count(컬럼): null이 아닌 행의 개수를 리턴.
select count(empno), count(mgr), count(comm)
from emp;

select count(*) from emp; -- 테이블의 행의 개수

-- 통계 함수: 합계, 평균, 최댓값, 최솟값, 분산, 표준편차
select sum(sal), avg(sal), max(sal), min(sal), variance(sal), stddev(sal)
from emp;

-- 단일행 함수와 다중행 함수는 함께 select할 수 없음!
-- select sal, sum(sal) from emp;
-- select nvl(sal, 0), sum(sal) from emp;

/*
그룹별 쿼리:
(예) 부서별 급여 평균, 부서별 인원수
(문법)
  select 컬럼, 함수 호출, ...
  from 테이블
  where 조건식(1)
  group by 그룹별로 묶어줄 변수(컬럼), ...
  having 조건식(2)
  order by 정렬 기준 변수(컬럼), ...;
*/

-- 부서별 급여 평균
select deptno, round(avg(sal), 2) as "AVG_SAL"
from emp
group by deptno
order by deptno;


