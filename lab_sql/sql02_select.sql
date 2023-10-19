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

