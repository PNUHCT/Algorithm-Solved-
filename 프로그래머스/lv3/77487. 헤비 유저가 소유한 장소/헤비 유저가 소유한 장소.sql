-- 이 서비스에서는 공간을 둘 이상 등록한 사람을 "헤비 유저"라고 부릅니다. 
-- 헤비 유저가 등록한 공간의 정보를 아이디 순으로 조회
SELECT *
FROM PLACES PL
WHERE PL.HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*)>1
    )
ORDER BY ID