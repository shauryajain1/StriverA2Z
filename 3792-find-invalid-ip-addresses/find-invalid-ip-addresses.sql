# Write your MySQL query statement below
SELECT ip, COUNT(*) AS invalid_count
FROM logs
WHERE ip NOT IN(   
SELECT ip -- Valid IPs
    FROM(
    SELECT *,
    SUBSTRING_INDEX(ip, '.', 1) AS split1,
    SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 2), '.', -1) AS split2,
    SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 3), '.', -1) AS split3,
    SUBSTRING_INDEX(SUBSTRING_INDEX(ip, '.', 4), '.', -1) AS split4
    FROM logs
        WHERE length(ip) - length( replace(ip, '.', '') ) = 3
    ) temp
    WHERE split1 <= 255 AND split2 <= 255 AND split3 <= 255 AND split4 <= 255 
    AND split1 NOT LIKE '0%' AND split2 NOT LIKE '0%' AND split3 NOT LIKE '0%' AND split4 NOT LIKE '0%'
)
GROUP BY ip
ORDER BY invalid_count DESC, ip DESC