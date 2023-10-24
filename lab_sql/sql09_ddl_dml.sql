/*
DDL(Data Definition Language): create, alter, drop, truncate
DML(Data Manipulation Language): insert, update, delete
*/

-- create table ... as select ...
-- 테이블의 모양(컬럼 이름, 데이터 타입)과 데이터를 복사.
-- emp 테이블의 전체 데이터를 ex_emp3 테이블을 생성하면서 복사:
create table ex_emp3
as select * from emp;

select * from ex_emp3;

-- emp 테이블의 모양(컬럼, 데이터 타입)과 똑같은 테이블 ex_emp4을 생성.
-- 데이터들을 복사하지 마세요.
create table ex_emp4
as select * from emp where empno = -1;

select * from ex_emp4;

-- truncate table: 테이블의 모든 행을 삭제하는 DDL
select * from ex_emp3;
truncate table ex_emp3;
select * from ex_emp3;

-- drop table: 테이블을 삭제하는 DDL
drop table ex_emp4;
select * from ex_emp4; --> 오류 발생: 테이블이 존재하지 않음.

-- DML
-- insert into table (col, ...) values (val, ...);
--   1개 행을 삽입(insert)
-- insert into table (col, ..) select ...;
--   select의 결과에 따라서 여러개의 행들을 삽입(insert)
select * from ex_emp3;
insert into ex_emp3
select * from emp where deptno = 10;

select * from bonus;

-- emp 테이블에서 comm이 null이 아닌 레코드를 bonus 테이블에 삽입:
insert into bonus
select ename, job, sal, comm from emp where comm is not null;

select * from bonus;

commit;

-- 테이블 데이터 업데이트
-- update 테이블이름 set 변수(컬럼) = 값, ... [where 조건식];
select * from emp;

-- 사번이 1004인 직원의 급여를 6000으로 변경
update emp
set sal = 6000
where empno = 1004;

commit; -- 현재 세션에서 지금까지의 트랜잭션을 DB에 영구 저장.

update emp set sal = 6000;
--> 조건절(where)을 사용하지 않으면 테이블의 모든 행의 값이 업데이트됨!

select * from emp;

rollback; -- 직전(최종) commit 상태로 되돌리기.

select * from emp;

-- 사번이 1004인 직원의 직무를 'MANAGER', 입사날짜를 '2023/10/24',
-- 부서번호를 40으로 업데이트:
update emp
set job = 'MANAGER', hiredate = '2023/10/24', deptno = 40
where empno = 1004;

select * from emp where empno = 1004;

-- 'ACCOUNTING' 부서에서 일하는 직원들의 급여를 10% 인상:
update emp
set sal = sal * 1.1
where deptno = (
    select deptno from dept where dname = 'ACCOUNTING'
);

select * from emp
where deptno = (
    select deptno from dept where dname = 'ACCOUNTING'
);

-- salgrade가 1인 직원들의 급여를 20% 인상:
select losal, hisal from salgrade where grade = 1;

update emp
set sal = sal * 1.2
where sal between
    (select losal from salgrade where grade = 1)
    and 
    (select hisal from salgrade where grade = 1);

select * from emp
where sal between 
    (select losal from salgrade where grade = 1)
    and
    (select hisal from salgrade where grade = 1);
    
commit;

-- delete: 테이블에서 행을 삭제하는 DML
-- delete from 테이블 [where 조건식];
delete from emp; -- 테이블에서 전체 행을 삭제.

rollback; -- 최종 커밋 상태(삭제 전)으로 되돌림.

select * from emp;

-- 사번이 1004인 직원 레코드(행)을 삭제:
delete from emp where empno = 1004;

commit;

-- 1987년에 입사한 직원(들)을 삭제:
select * from emp where to_char(hiredate, 'YYYY') = '1987';

delete from emp where to_char(hiredate, 'YYYY') = '1987';

rollback;

delete from emp
where hiredate between to_date('1987/01/01') 
    and to_date('1987/12/31');

select * from emp;
