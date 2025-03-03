-- 코드를 작성해주세요
WITH Percentage AS (
SELECT 
ID,
NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS SIZE_GROUP
FROM ECOLI_DATA 
),
COLONY_SIZE_NAME AS (
    SELECT ID,
        CASE
            WHEN SIZE_GROUP = 1 THEN 'CRITICAL'
            WHEN SIZE_GROUP = 2 THEN 'HIGH'
            WHEN SIZE_GROUP = 3 THEN 'MEDIUM'
            WHEN SIZE_GROUP = 4 THEN 'LOW'
        END AS COLONY_NAME
        FROM Percentage
)

SELECT A.ID, B.COLONY_NAME
FROM ECOLI_DATA AS A 
JOIN COLONY_SIZE_NAME AS B
ON A.ID = B.ID
ORDER BY A.ID
