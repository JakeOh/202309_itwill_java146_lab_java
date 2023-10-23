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

insert into students values (10, 'gildong');
--> ORA-00947: 값의 수가 충분하지 않습니다

insert into students (stuname, stuno) values ('gildong', 10);

insert into students (stuname, stuno) values (100, 'gildong');
--> ORA-01722: 수치가 부적합합니다

insert into students (stuname) values ('abcdefghijk');
--> ORA-12899: "SCOTT"."STUDENTS"."STUNAME" 열에 대한 값이 너무 큼(실제: 11, 최대값: 10)

select * from students;
commit;

-- 테이블 생성할 때 기본값 설정하기:
create table ex_users (
    no number(4),
    userid varchar2(20 byte),
    password varchar2(100 byte),
    age number(3) default 0,
    created_date date default sysdate
);

insert into ex_users (no, userid, password)
values (1, 'admin', '0000');
--> insert할 때 기본값이 설정된 컬럼들은 insert하는 값이 없으면
-- 설정된 기본값이 자동으로 insert됨.

insert into ex_users (no, userid, age)
values (2, 'guest', 10);
--> password 컬럼은 기본값이 설정되어 있지 않기 때문에 null.

select * from ex_users;

-- 테이블을 생성할 때 제약조건(contraint) 만들기
-- (1) primary key(고유키)
-- (2) not null
-- (3) unique
-- (4) check
-- (5) foreign key(외래키)

-- 테이블을 생성할 때 제약조건 만들기: 제약조건 이름을 설정하지 않음.
create table ex1 (
    id      number(2) primary key,
    name    varchar2(10 char) not null,
    phone   varchar2(13 char) unique,
    age     number(3) check (age >= 0),
    memo    varchar2(1000 char)
);

insert into ex1
values (1, '오쌤', '010-1234-5678', 16, '안녕하세요');

insert into ex1 (id, name) values (1, '홍길동');
--> 고유키(PK) 제약조건 위배: PK는 유일해야 함.

insert into ex1 (name) values ('홍길동');
--> PK 제약조건 위배: PK는 null이 될 수 없음.

insert into ex1 (id, phone) values (2, '010-0000-0000');
--> Not Null 제약조건 위배: name 컬럼은 NN.

insert into ex1 (id, name, phone) values (2, '홍길동', '010-1234-5678');
--> Unique 제약조건 위배: phone 컬럼은 unique.

insert into ex1 (id, name, age) values (2, '홍길동', -1);
--> Check 제약조건 위배: age >= 0

select * from ex1;
commit;

-- 테이블을 생성할 때 제약조건 만들기: 제약조건 이름을 설정.
create table ex2 (
    id      number(4)
            constraint ex2_id_pk primary key,
    name    varchar2(10 char)
            constraint ex2_name_nn not null,
    phone   varchar2(13 char)
            constraint ex2_phone_uq unique,
    gender  varchar2(1 char)
            constraint ex2_gender_chck check(gender in ('M', 'F'))
);

insert into ex2 values (1, '홍길동', '010-0000-0000', 'M');

insert into ex2 (id, name) values (1, '홍길동'); --> PK 위배
insert into ex2 (id) values (2); --> NN 위배
insert into ex2 (id, name, gender) values (2, '홍길동', 'm'); --> check 위배

select * from ex2;
commit;

-- 테이블을 생성할 때 제약조건 만들기: 컬럼 정의 따로, 제약조건 따로.
create table ex3 (
    -- 컬럼 정의(이름 & 데이터 타입)
    id      number(4),
    name    varchar2(10 char),
    phone   varchar2(13 char),
    gender  varchar2(1 char),
    -- 제약조건 정의(제약조건 이름 & 내용)
    constraint ex3_id_pk primary key (id),
    constraint ex3_name_nn check (name is not null), -- 주의(not null)
    constraint ex3_phone_uq unique (phone),
    constraint ex3_gender_chck check (gender in ('M', 'F'))
);

