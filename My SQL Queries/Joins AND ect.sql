SELECT e.first_name, e.last_name, t.name, a.address_text FROM employees AS e
JOIN addresses AS a
ON e.address_id=a.address_id
LEFT JOIN towns as t
ON a.town_id=t.town_id
ORDER BY e.first_name,e.last_name 
LIMIT 5;







SELECT e.employee_id,e.first_name, e.last_name, d.name FROM employees AS e
LEFT JOIN departments AS d
ON e.department_id=d.department_id
WHERE d.name='Sales'
ORDER BY e.employee_id DESC



SELECT e.employee_id,e.first_name, e.salary, d.name  FROM employees AS e
JOIN departments AS d
ON e.department_id=d.department_id
WHERE e.salary>15000
ORDER BY e.department_id DESC
LIMIT 5;



SELECT e.employee_id, e.first_name FROM employees AS e
LEFT JOIN employees_projects AS p
ON e.employee_id= p.employee_id
WHERE p.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;


SELECT e.first_name, e.last_name, e.hire_date, d.name FROM employees AS e
JOIN departments AS d
ON e.department_id= d.department_id
WHERE (e.hire_date)>'1999-01-01' AND d.name IN ('Finance','Sales')
ORDER BY e.hire_date;


SELECT e.employee_id, e.first_name , p.name FROM  employees AS e
JOIN employees_projects AS ep
ON e.employee_id=ep.employee_id
JOIN projects AS p
ON ep.project_id=p.project_id
WHERE DATE(p.start_date)>'2002-08-13' AND p.end_date IS NULL
ORDER BY e.first_name, p.name
LIMIT 5;


SELECT e.employee_id, e.first_name , IF(YEAR(p.start_date)>='2005',NULL,p.name) AS project_name FROM  employees AS e
JOIN employees_projects AS ep
ON e.employee_id=ep.employee_id
JOIN projects AS p
ON ep.project_id=p.project_id
WHERE e.employee_id=24 
ORDER BY project_name;



SELECT e.employee_id, e.first_name, e.manager_id, man.first_name FROM employees AS e
LEFT JOIN employees AS man
ON e.manager_id=man.employee_id
WHERE e.manager_id IN (3,7) 
ORDER BY e.first_name;



SELECT e.employee_id,  CONCAT_WS(' ',e.first_name,e.last_name) AS employee_name, 
                      CONCAT_WS(' ',man.first_name,man.last_name) AS manager_name,
							   d.name AS department_name FROM employees AS e
JOIN employees AS man
ON e.manager_id=man.employee_id
JOIN departments AS d
ON e.department_id=d.department_id
ORDER BY e.employee_id
LIMIT 5;

SELECT AVG(e.salary) AS min_average_salary FROM employees AS e
GROUP BY e.department_id
ORDER BY min_average_salary
LIMIT 1;


SELECT c.country_code, m.mountain_range,p.peak_name, p.elevation  FROM countries AS c
JOIN mountains_countries AS mc
ON mc.country_code=c.country_code
JOIN mountains AS m
ON mc.mountain_id=m.id
JOIN peaks AS p
ON p.mountain_id=m.id
WHERE c.country_name='Bulgaria' AND p.elevation>2835 
ORDER BY p.elevation DESC;


SELECT c.country_code, COUNT(mc.country_code)   AS mountain_range FROM countries AS c
JOIN mountains_countries AS mc
ON mc.country_code=c.country_code
JOIN mountains AS m
ON mc.mountain_id=m.id
GROUP BY c.country_code
HAVING c.country_code IN ('BG','RU','US')




SELECT c.country_name, r.river_name FROM countries AS c
LEFT JOIN countries_rivers AS cr
ON c.country_code=cr.country_code
LEFT JOIN rivers AS r
ON cr.river_id=r.id
WHERE c.continent_code='AF'
ORDER BY c.country_name
LIMIT 5



SELECT COUNT(c.country_code) FROM countries AS c 
WHERE c.country_code NOT IN (SELECT mc.country_code FROM mountains_countries AS mc)



SELECT c.country_name, p.elevation AS highest_peak_elevation, r.length AS longest_river_length FROM countries AS c
LEFT JOIN mountains_countries AS mc
ON mc.country_code=c.country_code
LEFT JOIN peaks AS p
ON mc.mountain_id=p.mountain_id
LEFT JOIN countries_rivers AS cr
ON c.country_code=cr.country_code
LEFT JOIN rivers AS r
ON cr.river_id=r.id
GROUP BY c.country_name
ORDER BY p.elevation DESC,r.length DESC, c.country_name
LIMIT 5;




SELECT pulse.continent_code AS continent_code, contries.qa AS currency_code ,pulse.currency_usage AS currency_usage 
					 FROM (SELECT vt.p AS continent_code, MAX(currency_usage) AS currency_usage FROM  (	
	
							SELECT c.continent_code AS p,c.currency_code AS q, COUNT(c.currency_code) AS currency_usage FROM countries c
							GROUP BY c.continent_code, c.currency_code
							HAVING currency_usage >1
							ORDER BY c.continent_code, c.currency_code) AS vt
					GROUP BY vt.p) AS pulse
JOIN (SELECT c.continent_code AS pa,c.currency_code AS qa, COUNT(c.currency_code) AS currency_usages FROM countries c
							GROUP BY c.continent_code, c.currency_code
							ORDER BY c.continent_code, c.currency_code) AS contries
ON pulse.continent_code=contries.pa AND pulse.currency_usage=contries.currency_usages
