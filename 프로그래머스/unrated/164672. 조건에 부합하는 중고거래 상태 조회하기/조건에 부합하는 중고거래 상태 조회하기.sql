-- USED_GOODS_BOARD 테이블에서 
-- 2022년 10월 5일에 등록된 중고거래 게시물의 
-- 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태를 조회
-- 거래상태가 SALE 이면 판매중, RESERVED이면 예약중, DONE이면 거래완료 분류하여 출력
-- 결과는 게시글 ID를 기준으로 내림차순 정렬해주세요.
SELECT UGB.BOARD_ID, UGB.WRITER_ID,	UGB.TITLE, UGB.PRICE, 
    CASE WHEN(UGB.STATUS LIKE "DONE") THEN "거래완료"
         WHEN(UGB.STATUS LIKE "SALE") THEN "판매중"
         ELSE "예약중"
    END AS 'STATUS'
FROM USED_GOODS_BOARD UGB
WHERE CREATED_DATE LIKE "2022-10-05"
ORDER BY UGB.BOARD_ID DESC
