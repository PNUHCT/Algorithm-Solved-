-- 동물 보호소에 들어온 동물 중 
-- 고양이와 개가 
-- 각각 몇 마리인지 조회
-- 고양이를 개보다 먼저 조회

SELECT ANIMAL_TYPE, COUNT(*) AS "count"
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE