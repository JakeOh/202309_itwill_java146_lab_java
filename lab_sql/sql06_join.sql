/*
join: 2개 이상의 테이블에서 검색하는 것.

문법:
(1) ANSI 표준 문법:
    select 컬럼, ...
    from 테이블1 join종류 테이블2 on join조건;
(2) Oracle 문법:
    select 컬럼, ...
    from 테이블1, 테이블2, ...
    where join조건;

join 종류:
(1) inner join
(2) outer join
    - left outer join
    - right outer join
    - full outer join
*/

-- inner join과 outer join의 차이점을 보기 위해서.
insert into emp (empno, ename, sal, deptno)
values (1004, '오쌤', 3500, 50);


commit;

-- 사번, 이름, 부서번호, 부서이름을 검색
-- ANSI 표준 문법. inner join인 경우에 inner는 생략 가능.
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp
    join dept on emp.deptno = dept.deptno;

-- Oracle 문법:
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp, dept
where emp.deptno = dept.deptno;
