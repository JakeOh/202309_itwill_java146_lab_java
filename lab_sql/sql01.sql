/*
 * 블록 주석(block comment)
 */

-- inline comment
-- SQL 문장은 세미콜론(;)으로 끝남.
-- Ctrl+Enter:
-- (1) 현재 커서가 있는 위치의 한 문장을 실행.
-- (2) 드래그(drag)로 선택된 문장을 실행.
-- F5: 스크립트(파일) 전체를 실행.

-- bonus 테이블에서 모든 컬럼의 내용을 검색:
select * from bonus;

-- SQL 문장에서 명령어(키워드), 테이블 이름, 컬럼 이름은 대/소문자를 구분하지 않음.
-- 테이블에 저장된 문자열 값들은 대/소문자를 구분함.

SELECT * FROM DEPT;

SELECT * FROM emp;

select * from SALGRADE;