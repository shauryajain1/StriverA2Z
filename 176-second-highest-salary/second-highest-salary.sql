# Write your MySQL query statement below
SELECT 
	salary as SecondHighestSalary
FROM (
    SELECT 
        e.*,
        DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
    FROM employee e
) res
WHERE res.rnk = 2
UNION ALL
SELECT NULL
WHERE NOT EXISTS (
    SELECT 1
    FROM (
        SELECT 
            e.*,
            RANK() OVER (ORDER BY salary DESC) AS rnk
        FROM employee e
    ) res
    WHERE res.rnk = 2
)
LIMIT 1;