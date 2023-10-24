/*
alter table: 테이블 변경
(1) 이름 변경: alter table ... rename ...
(2) 추가: alter table ... add ...
(3) 삭제: alter table ... drop ...
(4) 수정: alter table ... modify ...
*/

-- 1. 이름 변경:
-- (1) 테이블의 이름 변경: students -> student
alter table students rename to student;

-- 오라클에서 테이블들을 관리하기 위한 테이블: user_tables
select table_name from user_tables;
select * from user_tables;

-- (2) 컬럼 이름 변경: stuname -> name
alter table student rename column stuname to name;

-- 2. 추가(add)
-- (1) 제약조건(constraint) 추가: stuno 컬럼에 PK 제약조건 설정.
alter table student add constraint student_pk primary key (stuno);

-- 제약조건 이름 변경
alter table student rename constraint student_pk to student_stuno_pk;

-- (2) 새로운 컬럼 추가: department(학과 번호) - 정수(4자리)
alter table student add department number(4);

-- 3. 삭제(drop)
-- (1) 컬럼 삭제: department 컬럼 삭제
alter table student drop column department;

-- (2) 제약조건 삭제: student_stuno_pk 제약조건 삭제
alter table student drop constraint student_stuno_pk;

-- 4. 수정(modify): 컬럼 정의(데이터 타입, null 여부)를 수정.
-- student 테이블의 name 컬럼의 데이터 타입을 varchar2(20 char)로 변경.
-- not null로 변경.
alter table student modify name varchar2(20 char) not null;

-- modify는 제약조건의 내용을 변경하지 못함.
-- 제약조건 삭제(drop constraint) -> 제약조건 추가(add constraint).
