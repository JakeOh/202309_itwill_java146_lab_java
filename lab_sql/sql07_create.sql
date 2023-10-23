/*
SQL 종류:
1. DQL(Data Query Language): select 문장.
2. DML(Data Manipulation Language): insert, update, delete 문장.
3. DDL(Data Definition Language): create, alter, truncate, drop 문장.
4. TCL(Transaction Control Language): commit, rollback
   - commit: 데이터베이스의 변경 내용을 영구 저장.
   - rollback: 직전의 commit 상태로 되돌아가기.

테이블 생성:
create table 테이블이름 (
    컬럼이름 데이터타입 [제약조건 기본값],
    ...
);

데이터 타입에서 사용되는 키워드(예약어)는 데이터베이스 종류에 따라서 다름.
오라클 데이터 타입: number, varchar2, date, timestamp, clob, blob, ...
*/

/*
테이블 이름: students
컬럼:
  - stuno: 학생 번호. 숫자(6자리 정수).
  - stuname: 학생 이름. 문자열(10글자).
  - birthday: 학생 생일. 날짜.
*/
drop table students;  -- 테이블 삭제

create table students (
    stuno number(6),
    stuname varchar2(10 char),
    birthday date
);

-- DESCRIBE students; -- describe

/*
테이블에 행 추가:
insert into 테이블이름(컬럼, ...) values (값, ...);

테이블에 삽입하는 값의 개수가 컬럼의 개수와 같고, 순서가 컬럼 순서와 같은 경우:
insert into 테이블이름 values(값, ...);
*/
insert into students (stuno, stuname, birthday)
values (1, '홍길동', '2000/01/01');

insert into students values (2, '홍길동', '1999/12/31');

insert into students (stuno, stuname)
values (3, 'Gildong');

select * from students;

commit; -- insert한 내용들을 데이터베이스에 영구 저장.


