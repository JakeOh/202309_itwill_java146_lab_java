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

-- left outer join. outer는 생략 가능.
select e.empno, e.ename, e.deptno, d.dname
from emp e
    left join dept d on e.deptno = d.deptno;

-- Oralce에서 left outer join:
select e.empno, e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno(+);

-- right outer join. outer 생략 가능
select e.empno, e.ename, d.deptno, d.dname
from emp e
    right join dept d on e.deptno = d.deptno;

-- Oracle에서 right outer join:
select e.empno, e.ename, d.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno;

-- full outer join:
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e
    full join dept d on e.deptno = d.deptno;

-- Oracle에서는 full outer join 문법을 제공하지 않음.
-- left outer join 결과와 right outer join 결과를 합집합(union)할 수 있음.
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno(+) -- left outer join
union -- 합집합
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno; -- right outer join

-- equi join: join의 조건식이 = 연산자를 사용해서 만들어진 경우.
-- non-equi join: join의 조건식이 부등호를 사용해서 만들어진 경우.
-- 사번, 이름, 급여, 급여등급을 검색
select e.empno, e.ename, e.sal, s.grade
from emp e
    join salgrade s on e.sal between s.losal and s.hisal;
--    join salgrade s on e.sal >= s.losal and e.sal <= s.hisal;

select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

-- self-join: 같은 테이블에서 join을 하는 것.
-- 사번, 이름, 매니저 사번, 매니저 이름을 검색:
select e1.empno as "사번", e1.ename as "이름", 
    e1.mgr as "매니저 사번", e2.ename as "매니저 이름"
from emp e1
    join emp e2 on e1.mgr = e2.empno;

select e1.empno as "사번", e1.ename as "이름", 
    e1.mgr as "매니저 사번", e2.ename as "매니저 이름"
from emp e1, emp e2
where e1.mgr = e2.empno;
