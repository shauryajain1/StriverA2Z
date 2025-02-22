SELECT p.product_name, o.unit
FROM
(SELECT product_id, SUM(unit) AS unit
FROM (
SELECT * FROM Orders
WHERE YEAR(order_date) = 2020 AND MONTH(order_date) = 2) AS orders
GROUP BY product_id
HAVING SUM(unit) > 99) AS o
LEFT JOIN
Products p
ON o.product_id = p.product_id;