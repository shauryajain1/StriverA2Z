-- Write your PostgreSQL query statement below
select *
from users
where email ~ '^[a-zA-Z0-9]+@[a-zA-Z]+\.com$'
order by user_id;