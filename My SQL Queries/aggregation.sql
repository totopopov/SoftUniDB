SELECT e.deposit_group,e.magic_wand_creator,MIN(e.deposit_charge)
  FROM  wizzard_deposits AS e
  GROUP BY e.deposit_group,e.magic_wand_creator
  ORDER BY e.magic_wand_creator,e.deposit_group



SELECT CONCAT('[',(e.age MOD 10)*10,'-',(e.age MOD 10)*10+10,']') AS age_group, COUNT(*) 
FROM wizzard_deposits AS e
GROUP BY e.age MOD 10
ORDER BY 1


SELECT range, e.age
FROM wizzard_deposits AS e


SELECT 
  	(CASE
    WHEN e.age BETWEEN  0 AND 10 THEN '[0-10]'
    WHEN e.age BETWEEN 11 AND 20 THEN '[11-20]'
    WHEN e.age BETWEEN 21 AND 30 THEN '[21-30]'
    WHEN e.age BETWEEN 31 AND 40 THEN '[31-40]'
    WHEN e.age BETWEEN 41 AND 50 THEN '[41-50]'
    WHEN e.age BETWEEN 51 AND 60 THEN '[51-60]'
    ELSE '[61+]'
     END) AS age_group, COUNT(e.age)
  FROM wizzard_deposits AS e
GROUP BY age_group

SELECT e.age FROM wizzard_deposits AS e WHERE e.age BETWEEN 21 AND 30;


SELECT * FROM wizzard_deposits;



SELECT LEFT(e.first_name,1) AS first_letter FROM wizzard_deposits AS e
WHERE e.deposit_group='Troll Chest'
GROUP BY first_letter
ORDER BY first_letter


SELECT e.deposit_group, e.is_deposit_expired, AVG(e.deposit_interest) AS average_interest 
FROM wizzard_deposits AS e 
WHERE e.deposit_start_date>'1985-01-01'
GROUP BY e.deposit_group,e.is_deposit_expired
ORDER BY e.deposit_group DESC, e.is_deposit_expired


SELECT MIN(SELECT wizzard_deposits.deposit_group, AVG(wizzard_deposits.magic_wand_size)  AS `longest_magic_wand` FROM wizzard_deposits GROUP BY `longest_magic_wand`)
 FROM wizzard_deposits



SELECT SUM(e.deposit_amount-p.deposit_amount)  AS sum_difference
FROM wizzard_deposits AS e,
     wizzard_deposits AS p
    WHERE p.id=e.id+1
		
		








	SELECT e.department_id,
					(SELECT DISTINCT salary 
					FROM employees WHERE employees.department_id=e.department_id 
					ORDER BY salary DESC LIMIT 2,1)  AS third_highest_salary
	 FROM employees AS `e` 
	 GROUP BY department_id 
	 HAVING third_highest_salary IS NOT NULL;