-- 치킨 주문 분석:

-- 1. https://github.com/JakeOh/202309_itwill_java146_lab_java/blob/master/lab_sql/call_chicken.csv
-- 파일의 내용을 저장할 수 있는 테이블을 생성하는 SQL 문을 작성하세요.
-- CSV(comma-separated values) 파일:
--   행의 데이터들을 쉼표(,)로 구분해서 표 형태의 데이터를 저장한 텍스트 파일.
--   일반적으로는 구분자로 쉼표(comma)를 많이 사용하지만, 쉼표 이외의 다른 구분자를 사용하기도 함.
--   다른 종류의 컴퓨터(OS)들 간에 테이블 형태의 데이터들을 주고받을 때 많이 사용하는 파일 형식.
create table call_chicken (
    call_date   date,
    call_day    varchar2(1 char), -- varchar2에서 단위가 없으면 byte. 글자단위는 char 명시.
    district    varchar2(4 char),
    ages        varchar2(5 char),
    gender      varchar2(1 char),
    calls       number(4)
);

-- 2. SQLDeveloper에서 '데이터 임포트' 기능을 사용해서 CSV 파일의 내용을 테이블에 저장하세요.
--> 접속 창 -> 계정(Scott) -> 테이블 -> CALL_CHICKEN -> 오른쪽 클릭 -> 데이터 임포트

-- 3. 통화건수의 최솟값, 최댓값을 찾으세요.
-- 4. 통화건수가 최솟값이거나 최댓값인 레코드(행 전체)를 출력하세요.
-- 5. 평균적으로 어떤 요일에서 치킨 주문이 많을까요?
-- 6. 평균적으로 어떤 연령대가 치킨 주문을 많이 할까요?
-- 7. 평균적으로 어느 지역에서 치킨 주문을 많이 할까요?
-- 8. 치킨 주문에 성별 차이가 있을까요?
-- 9. 요일별, 연령대별 통화건수의 평균을 찾으세요.
-- 10. 구별, 성별 통화건수의 평균을 찾으세요.
-- 11. 요일별, 구별, 연령대별 통화건수의 평균을 찾으세요.
-- 3 ~ 11 문제의 출력은 통화건수 평균의 내림차순 정렬, 소숫점 2자리까지 반올림.
