-- Write your PostgreSQL query statement below

WITH analyze_sub  AS(
	SELECT * 
	FROM(
		SELECT user_id,  activity_type, activity_duration,
		ROUND(AVG(CASE WHEN activity_type = 'free_trial' THEN activity_duration ELSE 0 END) OVER(PARTITION BY user_id, activity_type),2) trial_avg_duration  ,
		ROUND(AVG(CASE WHEN activity_type = 'paid' THEN activity_duration ELSE 0 END) OVER(PARTITION BY user_id, activity_type),2) paid_avg_duration ,
		MIN(CASE WHEN activity_type = 'free_trial' THEN activity_date ELSE NULL END) OVER(PARTITION BY user_id) min_trial_actdate,
		MIN(CASE WHEN activity_type = 'paid' THEN activity_date ELSE NULL END) OVER(PARTITION BY user_id) min_paid_actdate
		FROM UserActivity
	)sub
	WHERE min_trial_actdate <= min_paid_actdate

)
SELECT user_id, MAX(trial_avg_duration) trial_avg_duration, MAX(paid_avg_duration) paid_avg_duration
FROM analyze_sub
GROUP BY user_id
ORDER BY user_id