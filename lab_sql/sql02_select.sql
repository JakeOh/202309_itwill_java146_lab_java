-- Alt+F10: SQL 새 워크시트 만들기.

-- select 컬럼 이름, ... from 테이블 이름;
-- select * from table; 테이블에서 모든 컬럼을 검색.

-- emp: 직원 테이블, dept: 부서 테이블
-- 직원 테이블에서 사번(empno), 직원 이름(ename)을 검색:
select empno, ename from emp;
select ename, empno from emp;

-- 부서 테이블에서 모든 컬럼을 검색.
select * from dept;
select deptno, dname, loc from dept;

-- 컬럼 이름에 별명(alias) 주기: as "별명"
-- 별명을 줄 때는 반드시 큰따옴표("")만 사용함!
-- 별명 이외의 문자열 값을 표현할 때는 작은따옴표('')를 사용!
select deptno as "부서 번호", dname as "부서 이름"
from dept;

-- 검색할 때 원하는 컬럼에만 별명을 줄 수 있음.
select deptno as "부서 번호", dname
from dept;

-- 연결 연산자(||): 2개 이상의 컬럼을 합쳐서 하나의 컬럼으로 출력.
-- '부서번호-부서이름' 형식의 문자열을 "부서 정보"라는 컬럼으로 출력:
select deptno || '-' || dname as "부서 정보"
from dept;

-- 부서 테이블을 검색해서 '... 부서는 ...에 있습니다.' 형식으로 결과 출력:
select
    dname || ' 부서는' || loc || '에 있습니다.' as "부서 정보"
from dept;

-- 검색 결과를 정렬해서 출력하기:
-- select 컬럼 이름, ... from 테이블 order by 컬럼 [asc/desc];
-- asc: 오름차순(ascending order) 정렬. 기본값. asc는 생략 가능.
-- desc: 내림차순(descending order) 정렬.

-- 부서 테이블의 모든 컬럼을 검색, 부서 번호 내림차순으로 출력:
select * from dept order by deptno desc;

-- 부서 테이블의 모든 컬럼을 검색, 부서 이름 오름차순으로 출력:
select * from dept order by dname;

-- 직원 테이블에서 사번, 이름, 급여를 검색, 사번 오름차순으로 출력:
select empno, ename, sal from emp order by empno;

-- 직원 테이블에서 사번, 이름, 급여를 검색, 급여 내림차순으로 출력:
select empno, ename, sal from emp order by sal desc;

-- 직원 테이블에서 부서번호, 사번, 이름을 검색
-- 정렬 순서: (1) 부서번호 오름차순, (2) 사번 오름차순
select deptno, empno, ename
from emp
order by deptno, empno;

-- 직원 테이블에서 부서번호, 이름, 급여를 검색
-- 정렬 순서: (1) 부서번호 오름차순, (2) 급여 내림차순
select deptno, ename, sal
from emp
order by deptno, sal desc;

-- 중복되지 않는 결과만 출력하기:
select job from emp;
select distinct job from emp; -- 중복되지 않는 업무이름들을 검색
-- (중복되지 않는) 업무 이름을 오름차순 정렬 출력:
select distinct job from emp order by job;

-- 중복되지 않는 부서번호, 직무를 출력, 부서번호 오름차순 정렬:
select distinct deptno, job from emp
order by deptno;