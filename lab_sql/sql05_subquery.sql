/*
서브쿼리(subquery): SQL 문장의 일부로 다른 SQL 문장이 포함되는 것.
*/

-- 급여 평균보다 더 많은 급여를 받는 직원들?
select avg(sal) from emp;
select * from emp where sal >= 2073.2;

select * from emp
where sal >= (select avg(sal) from emp);

select ename, sal,
    round(sal - (select avg(sal) from emp), 2) as "DIFF"
from emp;

-- ALLEN보다 적은 급여를 받는 직원들의 사번, 이름, 급여를 검색.
-- select * from emp where ename = 'ALLEN';
select empno, ename, sal
from emp
where sal < (
    select sal from emp where ename = 'ALLEN'
);

-- ALLEN과 같은 직무를 갖는 직원들의 사번, 이름, 부서번호, 직무, 급여를 검색.
select empno, ename, deptno, job, sal
from emp
where job = (
    select job from emp where ename = 'ALLEN'
);

-- SALESMAN의 급여 최댓값보다 더 많은 급여를 받는 직원들의 이름, 급여, 직무를 검색.
select ename, sal, job
from emp
where sal > (
    select max(sal) from emp where job = 'SALESMAN'
);

-- WARD의 연봉보다 더 많은 연봉을 받는 직원들의 이름, 급여, 수당, 연봉을 검색.
-- 연봉 = sal * 12 + comm. comm(수당)이 null인 경우에는 0으로 계산.
-- 정렬 순서: 연봉 내림차순.
select * from emp where ename = 'WARD'; -- WARD 직원의 레코드
select sal * 12 + comm from emp where ename = 'WARD'; -- WARD의 연봉
select sal * 12 + nvl(comm, 0) from emp; -- 모든 직원의 연봉

select ename, sal, comm, sal * 12 + nvl(comm, 0) as "ANNUAL_SAL"
from emp
where sal * 12 + nvl(comm, 0) > (
    select sal * 12 + nvl(comm, 0) from emp
    where ename = 'WARD'
)
order by ANNUAL_SAL desc;