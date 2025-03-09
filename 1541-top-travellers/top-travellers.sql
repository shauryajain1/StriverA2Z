# Write your MySQL query statement below
select u.name, if (sum(r.distance) is null,0, sum(r.distance)) as travelled_distance
from users u left join rides r on u.id=r.user_id
group by u.id
order by travelled_distance desc, u.name
