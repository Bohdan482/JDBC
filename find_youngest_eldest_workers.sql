WITH basequery AS (
                   SELECT     NAME
                            , BIRTHDAY
                            , DATEDIFF (YEAR, BIRTHDAY, CURRENT_DATE) AS AGE
                   FROM       worker
                   GROUP BY   NAME
                  )

SELECT    ('YOUNGEST') AS TYPE, NAME, BIRTHDAY
FROM       basequery
WHERE      AGE = (SELECT MIN(AGE) FROM basequery)

UNION

SELECT    ('ELDEST') AS TYPE, NAME, BIRTHDAY
FROM       basequery
WHERE      AGE = (SELECT MAX(AGE) FROM basequery)

ORDER BY TYPE DESC;