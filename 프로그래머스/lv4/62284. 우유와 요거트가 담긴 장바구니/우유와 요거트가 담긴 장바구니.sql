-- 우유(Milk)와 요거트(Yogurt)를 동시에 구입한 장바구니가 있는지
-- 우유와 요거트를 동시에 구입한 장바구니의 아이디를 조회
-- 결과는 장바구니의 아이디 순

SELECT DISTINCT(MILK.CART_ID)
FROM (SELECT CART_ID, NAME FROM CART_PRODUCTS WHERE NAME = "Milk") AS MILK
INNER JOIN (SELECT CART_ID, NAME FROM CART_PRODUCTS WHERE NAME = "Yogurt") AS YOGURT
    ON MILK.CART_ID LIKE YOGURT.CART_ID
WHERE MILK.NAME = "Milk" AND YOGURT.NAME = "Yogurt"
ORDER BY MILK.CART_ID