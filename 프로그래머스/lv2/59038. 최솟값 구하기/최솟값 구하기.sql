-- 동물 보호소에 
-- 가장 먼저 들어온 동물은 
-- 언제 들어왔는지 조회

SELECT DATETIME AS "시간"
FROM ANIMAL_INS
ORDER BY DATETIME ASC LIMIT 1