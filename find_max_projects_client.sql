WITH basequery AS (
                   SELECT client.NAME
                        , COUNT(project.CLIENT_ID) AS PROJECT_COUNT
                   FROM   project
                   JOIN   client ON project.CLIENT_ID = client.ID
                   GROUP BY NAME
                   )

SELECT NAME, PROJECT_COUNT
FROM   basequery
WHERE  PROJECT_COUNT = (SELECT  MAX(PROJECT_COUNT) FROM basequery);