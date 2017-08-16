SELECT *
FROM (
SELECT c.id, c.name, COUNT(uc.user_id) AS prime
FROM contests AS c
LEFT JOIN users_contests AS uc ON uc.contest_id= c.id
GROUP BY c.id, c.name
ORDER BY COUNT(uc.user_id) DESC
LIMIT 5) AS p
ORDER BY p.prime, p.id