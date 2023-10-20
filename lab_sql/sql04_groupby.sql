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

-- 모든 문제에서 소수점은 반올림해서 소수점 이하 2자리까지 표시
-- Ex1. 부서별 급여 평균, 표준편차를 부서번호 오름차순으로 출력.
select deptno, 
    round(avg(sal), 2) as "AVG_SAL", 
    round(stddev(sal), 2) as "STD_SAL"
from emp
group by deptno
order by deptno;

-- Ex2. 직무별 직무, 직원수, 급여 최댓값, 최솟값, 평균을 직무 오름차순으로 출력.
select job, count(job), 
    max(sal) as "MAX_SAL", min(sal) as "MIN_SAL", 
    round(avg(sal), 2) as "AVG_SAL"
from emp
group by job
order by job;

-- Ex3. 부서별/직무별로 부서번호, 직무, 직원수, 급여 평균을 검색
--      정렬 순서: (1) 부서번호 (2) 직무
select deptno, job, count(*), round(avg(sal), 2)
from emp
group by deptno, job
order by deptno, job;

-- Ex4. 입사연도별 사원수를 검색. (힌트) to_char(날짜, 포맷) 이용.
select to_char(hiredate, 'YYYY-MM-DD') from emp;
select to_char(hiredate, 'YYYY') from emp;
select to_char(hiredate, 'YYYY') as "YEAR", count(*) as "COUNT"
from emp
group by to_char(hiredate, 'YYYY')
order by YEAR;
-- select 절에서 만든 별명(alias)는 order by 절에서만 사용 가능!

-- where 절은 테이블에서 조건에 맞는 행들을 선택할 때.
-- having 절은 그룹별 쿼리에서 조건에 맞는 그룹을 선택할 때.

-- 부서별 급여 평균 검색. 급여 평균이 2000 이상인 부서만 검색:
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 2000
order by deptno;

-- Ex. mgr 컬럼이 null이 아닌 직원들 중에서 부서별 급여 평균을 검색.
-- 정렬순서: 부서번호 오름차순.

-- Ex. 직무별 사원수를 검색. PRESIDENT는 검색 제외. 
-- 직무별 사원수가 3명 이상인 직무만 검색.
-- 정렬순서: 직무의 오름차순.

-- Ex. 입사연도, 부서번호, 입사연도별 부서별 사원수 검색
-- 1980년은 검색에서 제외.
-- 연도별 부서별 사원수가 2명 이상인 경우만 선택.
-- (1) 연도별, (2)부서별 오름차순 출력.
