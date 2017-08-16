
SELECT u.id, u.username, u.email FROM users AS u 
ORDER BY u.id;

SELECT c.id, c.name FROM categories AS c 
WHERE c.parent_id IS NULL
ORDER BY c.id;

SELECT p.id, p.name, p.tests FROM problems AS p 
WHERE  p.tests > p.points AND p.name LIKE '% %'
ORDER BY p.id DESC;


SELECT p.id, CONCAT(ca.name,' - ',c.name,' - ',p.name) FROM problems AS p 
INNER JOIN contests AS c ON c.id=p.contest_id
INNER JOIN categories AS ca ON ca.id=c.category_id
ORDER BY p.id;


SELECT c.id, c.name FROM categories AS c WHERE
c.id NOT IN(SELECT DISTINCT cat.parent_id FROM categories AS cat WHERE cat.parent_id IS NOT NULL)
ORDER BY c.name, c.id;


SELECT u.id, u.username, u.password FROM users AS u 
INNER JOIN users AS us ON us.password=u.password AND u.id<>us.id
GROUP BY u.id
ORDER BY u.username, u.id;



SELECT r.id, r.name, r.contestants
FROM (
SELECT uc.contest_id AS id, c.name AS name, COUNT(uc.user_id) AS contestants
FROM users_contests AS uc
INNER JOIN contests AS c ON c.id=uc.contest_id
GROUP BY uc.contest_id, c.name
ORDER BY contestants DESC
LIMIT 5) AS r
ORDER BY r.contestants, r.id;




SELECT s.id, u.username,p.name, CONCAT(s.passed_tests,' / ',p.tests)    FROM submissions AS s
INNER JOIN users AS u ON u.id=s.user_id
INNER JOIN problems AS p ON s.problem_id=p.id
WHERE s.user_id=(SELECT s.user_id FROM users_contests AS s 
GROUP BY s.user_id
ORDER BY COUNT(s.contest_id) DESC LIMIT 1)
ORDER BY s.id DESC;



SELECT c.id, c.name, p.maximum_points
FROM contests AS c
INNER JOIN (
SELECT p.contest_id, SUM(p.points) AS maximum_points
FROM problems AS p
GROUP BY p.contest_id) AS p ON p.contest_id = c.id
ORDER BY p.maximum_points DESC, c.id;



SELECT c.id, c.name, COUNT(s.id)  FROM contests AS c
INNER JOIN problems AS p ON p.contest_id=c.id
INNER JOIN submissions AS s ON s.problem_id=p.id
INNER JOIN users  AS us ON s.user_id = us.id
INNER JOIN users_contests AS uc ON us.id=uc.user_id AND uc.contest_id=c.id
GROUP BY c.id, c.name
ORDER BY COUNT(s.id) DESC, c.id


SELECT FROM users_contests AS uc WHERE uc.

