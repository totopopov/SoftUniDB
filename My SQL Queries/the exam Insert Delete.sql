INSERT INTO submissions(passed_tests,
	problem_id ,
	user_id )
	
SELECT CEIL(SQRT(POW(CHARACTER_LENGTH(p.name),3)) - CHARACTER_LENGTH(p.name)), p.id, CEIL(p.id*3.0/2)
FROM problems AS p
WHERE p.id BETWEEN 1 AND 10;




UPDATE problems AS p
INNER JOIN contests AS c ON c.id=p.contest_id
INNER JOIN categories AS ca ON  ca.id=c.category_id
INNER JOIN (SELECT SUM(s.id) AS suma, s.problem_id AS problem_id  FROM submissions AS s GROUP BY s.problem_id) AS sa ON sa.problem_id=p.id
SET p.tests= (CASE 
					WHEN p.id MOD 3=0 THEN CHARACTER_LENGTH(ca.name)
					WHEN p.id MOD 3=1 THEN sa.suma
					WHEN p.id MOD 3=2 THEN CHARACTER_LENGTH(c.name)
					END
					) WHERE p.tests=0
					
					 
;

SET FOREIGN_KEY_CHECKS=0;
DELETE FROM users WHERE id NOT IN(SELECT uc.user_id FROM users_contests AS uc);
SET FOREIGN_KEY_CHECKS=1;

SELECT uc.user_id FROM users_contests AS uc