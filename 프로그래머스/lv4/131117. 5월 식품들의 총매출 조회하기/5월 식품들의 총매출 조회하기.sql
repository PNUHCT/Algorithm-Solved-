-- FOOD_PRODUCT와 FOOD_ORDER 테이블에서 -> FROM & JOIN
-- 생산일자가 2022년 5월인 식품들의 -> WHERE
-- 식품 ID, 식품 이름, 총매출을 조회 -> SELECT
-- 이때 결과는 총매출을 기준으로 내림차순 정렬 -> ORDER BY
-- 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬 -> ORDER BY

SELECT FP.PRODUCT_ID, FP.PRODUCT_NAME,
    SUM(FO.AMOUNT * FP.PRICE) AS TOTAL_SALES
    # DATE_FORMAT(FO.PRODUCE_DATE, "%Y-%m-%d")
FROM FOOD_PRODUCT FP
INNER JOIN FOOD_ORDER FO ON FO.PRODUCT_ID LIKE FP.PRODUCT_ID
WHERE DATE_FORMAT(FO.PRODUCE_DATE, "%Y-%m") LIKE "2022-05"
GROUP BY FP.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, FP.PRODUCT_ID