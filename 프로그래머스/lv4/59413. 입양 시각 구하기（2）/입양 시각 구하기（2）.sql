-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다.
-- 0시부터 23시까지, 
-- 각 시간대별로 입양이 몇 건이나 발생했는지 조회
-- 결과는 시간대 순으로 정렬
# SELECT 
#     # DATE_FORMAT(DATETIME, "%H") AS HOUR,
#     HOUR(DATETIME) AS "HOUR",
#     COUNT(ANIMAL_ID) AS "COUNT"
# FROM ANIMAL_OUTS
# GROUP BY HOUR(DATETIME)
# ORDER BY HOUR
SET @HOUR = -1;

SELECT 
    (@HOUR := @HOUR+1) AS "HOUR",
    (SELECT COUNT(*) 
       FROM ANIMAL_OUTS
       WHERE HOUR(DATETIME) = @HOUR
       ) AS "COUNT"
FROM ANIMAL_OUTS
WHERE @HOUR < 23





# GROUP BY HOUR(DATETIME)
# ORDER BY HOUR