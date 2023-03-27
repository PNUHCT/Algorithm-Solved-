-- REST_INFO와 REST_REVIEW 테이블에서 -> FROM, JOIN
-- 서울에 위치한 식당들의 WHERE
-- 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수를 조회 -> SELECT
-- 리뷰 평균점수는 소수점 세 번째 자리에서 반올림 -> ROUND, 2 [이게 핵심]
-- 결과는 평균점수를 기준으로 내림차순 정렬 -> ORDER BY 
-- 평균점수가 같다면 즐겨찾기수를 기준으로 내림차순 정렬 -> ORBER BY 

-- ROUND(AVG()) + GROUP BY()

SELECT RI.REST_ID, RI.REST_NAME, RI.FOOD_TYPE, RI.FAVORITES, RI.ADDRESS, RR.SCORE
FROM REST_INFO RI
INNER JOIN (
    SELECT REST_ID, ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
    FROM REST_REVIEW
    GROUP BY REST_ID
) AS RR ON RR.REST_ID LIKE RI.REST_ID
WHERE ADDRESS LIKE "서울%"
ORDER BY SCORE DESC, FAVORITES DESC