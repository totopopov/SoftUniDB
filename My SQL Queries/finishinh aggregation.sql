SELECT e.department_id,MIN(e.salary) 
FROM employees AS e
WHERE e.department_id IN (2,5,7) 
AND e.hire_date> '2000-01-01'
GROUP BY e.department_id
ORDER BY e.department_id;


SELECT e.department_id, AVG(IF( e.department_id=1, e.salary+5000,e.salary))
FROM employees AS e
WHERE e.salary>30000 
AND e.manager_id!=42
GROUP BY e.department_id
ORDER BY e.department_id;


SELECT e.department_id, MAX(e.salary) AS max_salary
FROM employees AS e
GROUP BY e.department_id
HAVING max_salary NOT BETWEEN 30000 AND 70000
ORDER BY e.department_id;


SELECT COUNT(*) AS `count` FROM employees e 
WHERE e.manager_id IS NULL


SELECT e.department_id, SUM(e.salary) 
FROM employees AS e 
GROUP BY e.department_id
ORDER BY e.department_id;
