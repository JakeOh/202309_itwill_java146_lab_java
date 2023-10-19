/*
테이블에서 데이터 검색:
  (1) projection: 테이블에서 원하는 컬럼들을 선택.
  (2) selection: 테이블에서 조건을 만족하는 행(레코드)들를 검색.
문법: select 컬럼, ... from 테이블 where 조건식 order by 컬럼, ...;
조건식에서 사용되는 연산자들:
  (1) 비교 연산자: =, !=, >, >=, <, <=, is null, is not null, ...
  (2) 논리 연산자: and, or, not
*/

-- 직원 테이블에서 10번 부서에서 근무하는 직원들의 부서번호, 사번, 이름 출력.
-- 정렬 순서: 사번
select deptno, empno, ename
from emp
where deptno = 10
order by empno;

-- 직원 테이블에서 수당(comm)이 null이 아닌 직원들의 
-- 사번, 부서번호, 이름, 수당을 출력.
-- 정렬 순서: 사번
select empno, deptno, ename, comm
from emp
where comm is not null
order by empno;

-- 직원 테이블에서 급여가 2000 이상인 직원들의 이름, 직무, 급여를 출력.
select ename, job, sal
from emp
where sal >= 2000;

-- 직원 테이블에서 급여가 2000 이상 3000 이하인 직원들의
-- 이름, 직무, 급여를 출력.
-- 정렬 순서: 급여.
select ename, job, sal
from emp
where sal >= 2000 and sal <= 3000
order by sal;

select ename, job, sal
from emp
where sal between 2000 and 3000
order by sal;

-- 직원 테이블에서 10번 부서 또는 20번 부서에서 근무하는
-- 직원들의 부서번호, 이름, 급여를 검색.
-- 정렬 순서: (1) 부서 번호 오름차순, (2) 급여 내림차순.
select deptno, ename, sal
from emp
where deptno = 10 or deptno = 20
order by deptno, sal desc;

select deptno, ename, sal
from emp
where deptno in (10, 20)
order by deptno, sal desc;

-- 직원 테이블에서 직무가 'CLERK'인 
-- 직원들의 직무, 이름, 급여를 출력.
-- 정렬 순서: 이름.

-- 직원 테이블에서 직무가 'CLERK' 또는 'MANAGER'인 
-- 직원들의 직무, 이름, 급여를 검색.
-- 정렬 순서: (1) 직무, (2) 급여.

-- 직원 테이블에서 20번 부서에서 근무하는 CLERK의 
-- 모든 정보(컬럼)을 검색.

-- 직원 테이블에서 CLERK, ANALYST, MANAGER가 아닌 
-- 직원들의 사번, 이름, 직무, 급여를 검색
-- 정렬 순서: 사번.
