-- 이름에 "EL"이 들어가는 개의 아이디와 이름을 조회
-- 결과는 이름 순으로 조회
-- 단, 이름의 대소문자는 구분하지 않습니다.

-- WHERE 조건1 : 이름에 "EL"이 대소문자 구분없이 키워드 검색
  # => LOWER(컬럼명) LIKE LOWER("%키워드%") 

-- WHERE 조건2 : 동물 타입이 개
  # => 컬럼명 LIKE "키워드"
  
-- 정렬조건 : 이름
  # => ORDER BY 컬럼명
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE LOWER(NAME) LIKE LOWER("%el%") AND ANIMAL_TYPE LIKE "Dog"
ORDER BY NAME