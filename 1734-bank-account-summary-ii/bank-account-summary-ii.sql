# Write your MySQL query statement below
SELECT u.name AS name, SUM(amount) AS balance
FROM Users AS u JOIN Transactions AS t
ON u.account = t.account
GROUP BY u.account
HAVING balance>10000