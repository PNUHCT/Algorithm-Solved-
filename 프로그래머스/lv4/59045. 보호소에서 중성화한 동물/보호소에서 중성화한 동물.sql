-- 보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다.
-- 보호소에 들어올 당시에는 중성화되지 않았지만, -> ANIMAL_INS -> SEX_UPON_INTAKE (Intact Male, Intact Female)
-- 보호소를 나갈 당시에는 중성화된 -> ANIMAL_OUTS -> SEX_UPON_OUTCOME (Spayed Female, Neutered Male)
-- 동물의 아이디와 생물 종, 이름을 조회
-- 아이디 순으로 조회

SELECT INS.ANIMAL_ID, INS.ANIMAL_TYPE, INS.NAME
FROM ANIMAL_INS INS
INNER JOIN ANIMAL_OUTS OUTS ON INS.ANIMAL_ID LIKE OUTS.ANIMAL_ID
WHERE
    INS.SEX_UPON_INTAKE IN ("Intact Male", "Intact Female")
    AND
    OUTS.SEX_UPON_OUTCOME IN ("Spayed Female", "Neutered Male")
ORDER BY INS.ANIMAL_ID