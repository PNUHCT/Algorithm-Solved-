-- 보호소에서는 
-- 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 
-- 09:00부터 19:59까지, 
-- 각 시간대별로 입양이 몇 건이나 발생했는지 조회
-- 결과는 시간대 순으로 정렬
SELECT DATE_FORMAT(DATETIME, "%H") AS HOUR, COUNT(DATETIME) AS "COUNT"
FROM ANIMAL_OUTS  
GROUP BY HOUR
HAVING HOUR BETWEEN 9 AND 20
ORDER BY HOUR