# Write your MySQL query statement below
# Write your MySQL query statement below
WITH CTE AS (
    SELECT s.product_id, p.product_name,
        FIRST_VALUE(s.sale_date) OVER (PARTITION BY s.product_id ORDER BY s.sale_date
        ) AS first_sale_date,
        MAX(s.sale_date) OVER (PARTITION BY s.product_id) AS last_sale_date
    FROM Sales s
    LEFT JOIN Product p 
        ON s.product_id = p.product_id
)

SELECT DISTINCT product_id, product_name
FROM CTE
WHERE first_sale_date BETWEEN '2019-01-01' AND '2019-03-31'
AND last_sale_date <= '2019-03-31'
;