WITH   basequery AS(
                    SELECT ID AS PROJECT_ID
                         , DATEDIFF(MONTH, START_DATE, FINISH_DATE) AS MONTH_COUNT
                    FROM    project
                    GROUP BY ID
                    )

SELECT PROJECT_ID, MONTH_COUNT
FROM   basequery
WHERE  MONTH_COUNT = (SELECT MAX(MONTH_COUNT) FROM basequery);