WITH     baseTable AS (
                       SELECT PROJECT_ID
                            , (DATEDIFF(MONTH, START_DATE, FINISH_DATE) * SALARY) AS PRICE
                       FROM   project
                       JOIN   project_worker ON project_worker.PROJECT_ID = project.ID
                       JOIN   worker ON project_worker.WORKER_ID = worker.ID
                       GROUP BY PROJECT_ID, SALARY
                       )

SELECT    PROJECT_ID, SUM(PRICE) AS PRICE
FROM      baseTable
GROUP BY  PROJECT_ID
ORDER BY  PRICE DESC;