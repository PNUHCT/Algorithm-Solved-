-- USER_INFO 테이블과 ONLINE_SALE 테이블에서 -> FROM, JOIN
-- 2021년에 가입한 전체 회원들 중 -> WHERE
-- 상품을 구매한 회원수와, 상품을 구매한 회원의 비율 -> GROUP BY
-- (=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을
-- 년, 월 별로 출력 -> SELECT

-- 상품을 구매한 회원의 비율은 소수점 두번째자리에서 반올림
-- 전체 결과는 년을 기준으로 오름차순 정렬
-- 년이 같다면 월을 기준으로 오름차순 정렬

-- 실패
SELECT 
    YEAR(SALES_DATE) AS YEAR, 
    MONTH(SALES_DATE) AS MONTH, 
    COUNT(DISTINCT(OS.USER_ID)) AS PUCHASED_USERS,
    -- 중복을_제외한_각_2021년_월별_가입자를 2021년_전체_가입자로 나눈 값
    ROUND(COUNT(DISTINCT(OS.USER_ID))/(
        SELECT COUNT(USER_ID) FROM USER_INFO WHERE YEAR(JOINED) LIKE "2021"
    ), 1) AS PUCHASED_RATIO
FROM USER_INFO UI
INNER JOIN ONLINE_SALE OS ON OS.USER_ID LIKE UI.USER_ID
-- 2021년도 가입자들 중
WHERE YEAR(JOINED) LIKE "2021"
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH


-- 158명
# SELECT *
# FROM ONLINE_SALE OS 
# LEFT JOIN (SELECT * FROM USER_INFO WHERE DATE_FORMAT(JOINED, "%Y") LIKE "2021") AS UI
#     ON OS.USER_ID LIKE UI.USER_ID 