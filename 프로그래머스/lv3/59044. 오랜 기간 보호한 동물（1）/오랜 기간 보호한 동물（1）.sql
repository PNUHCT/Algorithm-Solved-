-- 아직 입양을 못 간 동물 중, 
-- 가장 오래 보호소에 있었던
-- 동물 3마리의 이름과 보호 시작일을 조회
-- 결과는 보호 시작일 순으로 조회
SELECT
    INS.NAME, 
    INS.DATETIME
FROM ANIMAL_INS INS
LEFT JOIN ANIMAL_OUTS OUTS ON OUTS.ANIMAL_ID LIKE INS.ANIMAL_ID
WHERE OUTS.ANIMAL_ID IS NULL 
ORDER BY INS.DATETIME LIMIT 3