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
select job, ename, sal
from emp
where job = 'CLERK'
order by ename;

-- 직원 테이블에서 직무가 'CLERK' 또는 'MANAGER'인 
-- 직원들의 직무, 이름, 급여를 검색.
-- 정렬 순서: (1) 직무, (2) 급여.
select job, ename, sal
from emp
-- where job = 'CLERK' or job = 'MANAGER'
where job in ('CLERK', 'MANAGER')
order by job, sal;

-- 직원 테이블에서 20번 부서에서 근무하는 CLERK의 
-- 모든 정보(컬럼)을 검색.
select * from emp
where deptno = 20 and job = 'CLERK';

-- 직원 테이블에서 CLERK, ANALYST, MANAGER가 아닌 
-- 직원들의 사번, 이름, 직무, 급여를 검색
-- 정렬 순서: 사번.
select empno, ename, job, sal
from emp
-- where job != 'CLERK' and job != 'ANALYST' and job != 'MANAGER'
where job not in ('CLERK', 'ANALYST', 'MANAGER')
order by empno;

-- 숫자 타입 뿐만 아니라, 문자열과 날짜 타입도 대소비교가 가능.
-- (예) 'a' < 'b', 2023/10/19 < 2023/10/20

-- '1987/01/01' 이후에 입사한 직원들의 레코드(모든 컬럼)를 출력.
-- 정렬 순서: 입사일 오름차순.
select * from emp
where hiredate >= '1987/01/01'
order by hiredate;
-- 오라클은 hiredate 컬럼의 값(날짜 타입)을 문자열 타입으로 변환해서
-- '1987/01/01' 문자열과 크기 비교를 수행 - 암시적 타입 변환.

select * from emp
where hiredate >= to_date('1987/01/01')
order by hiredate;
-- to_date(문자열): 문자열을 날짜 타입으로 변환하는 함수.

-- 특정 문자열로 시작하거나, 특정 문자열이 포함된 값을 찾는 쿼리 - like 검색
-- 이름이 'A'로 시작하는 직원들:
select ename from emp where ename like 'A%';

-- like 검색에서 사용되는 wildcard
-- (1) %: 글자 수 제한 없음.
-- (2) underscore(_): 밑줄이 있는 자리에 어떤 문자가 있어도 됨.
select * from emp where job like '_LERK';
