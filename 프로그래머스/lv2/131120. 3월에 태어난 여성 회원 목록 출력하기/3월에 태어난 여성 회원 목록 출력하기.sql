-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') FROM MEMBER_PROFILE where TLNO is not NULL AND GENDER = 'W' AND MONTH(DATE_OF_BIRTH) = 3 order by MEMBER_ID