-- 코드를 입력하세요
-- ONLINE_SALE 테이블과 OFFLINE_SALE 테이블에서 
-- 2022년 3월의 오프라인/온라인 상품 판매 데이터의 
-- 판매 날짜, 상품ID, 유저ID, 판매량을 출력하는 SQL문
-- OFFLINE_SALE 테이블의 판매 데이터의 USER_ID 값은 NULL 로 표시
-- 결과는 판매일을 기준으로 오름차순 정렬
-- 판매일이 같다면 상품 ID를 기준으로 오름차순
-- 상품ID까지 같다면 유저 ID를 기준으로 오름차순 정렬

SELECT 
    DATE_FORMAT(SALES_DATE, "%Y-%m-%d") SALES_DATE
    , PRODUCT_ID
    , USER_ID
    , SALES_AMOUNT
FROM ONLINE_SALE
WHERE SALES_DATE LIKE ('2022-03-%')
UNION
SELECT
    DATE_FORMAT(SALES_DATE, "%Y-%m-%d") SALES_DATE
    , PRODUCT_ID
    , NULL
    , SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE LIKE ('2022-03-%')
ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC