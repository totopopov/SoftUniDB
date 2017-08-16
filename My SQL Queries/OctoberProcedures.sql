SELECT e.employee_id, e.hire_date, e.salary, e.branch_id FROM employees AS e 
WHERE e.salary>2000 AND DATE(e.hire_date)>'2009-06-15';

SELECT c.first_name, c.date_of_birth, FLOOR(TIMESTAMPDIFF(day,c.date_of_birth,'2016-10-01')/360) AS `age` FROM customers AS c
WHERE (TIMESTAMPDIFF(day,c.date_of_birth,'2016-10-01')/360) BETWEEN 40 and 50 ;

SELECT c.customer_id, c.first_name, c.last_name, c.gender, ci.city_name  FROM customers AS c 
INNER JOIN cities AS ci ON ci.city_id=c.city_id WHERE (c.last_name LIKE 'Bu%' OR c.first_name LIKE '%a') AND CHAR_LENGTH(ci.city_name)>7
ORDER BY c.customer_id;


	SELECT e.employee_id, e.first_name, a.account_number FROM employees As e 
	INNER JOIN employees_accounts AS ea ON ea.employee_id=e.employee_id
	INNER JOIN accounts AS a ON a.account_id=ea.account_id
	WHERE YEAR(a.start_date)> 2012
	ORDER BY e.first_name DESC
	LIMIT 5;
	

SELECT c.city_name,b.name, COUNT(e.employee_id) AS employees_count FROM cities AS c 
INNER JOIN branches AS b ON b.city_id=c.city_id AND c.city_id  NOT IN(4,5)
INNER JOIN employees AS e ON e.branch_id=b.branch_id
GROUP BY c.city_name,b.name
HAVING COUNT(e.employee_id)>2;


SELECT SUM(l.amount) AS total_loan_amount,MAX(l.interest) AS max_interest,MIN(e.salary) AS min_employee_salary
FROM loans as l, employees AS e
WHERE l.loan_id IN(SELECT el.loan_id FROM employees_loans AS el) 
AND e.employee_id IN(SELECT el.employee_id FROM employees_loans AS el) ;

SELECT SUM(l.amount) AS total_loan_amount,MAX(l.interest) AS max_interest
FROM loans as l
WHERE l.loan_id IN(SELECT el.loan_id FROM employees_loans AS el) 


SELECT SUM(l.amount) AS total_loan_amount, MAX(l.interest) AS max_interest, MIN(e.salary) AS min_employee_salary  FROM employees AS e 
JOIN employees_loans  AS el ON el.employee_id=e.employee_id
JOIN loans AS l ON l.loan_id=el.loan_id;

(SELECT e.first_name, c.city_name FROM  employees AS e
INNER JOIN branches AS b ON b.branch_id=e.branch_id
INNER JOIN cities AS c ON b.city_id=c.city_id
LIMIT 3)
UNION 
(SELECT c.first_name,ci.city_name FROM customers AS c
INNER JOIN cities AS ci ON ci.city_id=c.city_id
LIMIT 3);



SELECT c.customer_id, c.height FROM customers AS c 
WHERE c.customer_id NOT IN(SELECT a.customer_id FROM accounts AS a) AND c.height BETWEEN 1.74 AND 2.04;

SELECT c.customer_id,l.amount  FROM customers AS c 
INNER JOIN loans AS l ON l.customer_id=c.customer_id
WHERE l.amount>(SELECT AVG(l.amount) FROM loans AS l 
INNER JOIN customers AS c ON l.customer_id=c.customer_id
WHERE c.gender='M') 
ORDER BY c.last_name
LIMIT 5;

SELECT c.customer_id,c.first_name,a.start_date FROM customers AS c 
INNER JOIN accounts AS a ON a.customer_id=c.customer_id
ORDER BY a.start_date 
LIMIT 1;


DELIMITER $$
CREATE FUNCTION udf_concat_string (s1 VARCHAR(50), s2 VARCHAR(50))
RETURNS VARCHAR(100)
BEGIN
DECLARE outcome VARCHAR(100);
SET outcome := CONCAT(REVERSE(s1),REVERSE(s2));
RETURN outcome;
END$$
DELIMITER ;

SELECT udf_concat_string('charlie', 'eat')


DELIMITER $$
CREATE PROCEDURE usp_customers_with_unexpired_loans  (IN customer_id INT)
BEGIN
SELECT c.customer_id, c.first_name, l.loan_id FROM customers AS c
INNER JOIN loans AS l ON l.customer_id=c.customer_id
WHERE c.customer_id=customer_id AND l.expiration_date IS NULL;
END$$
DELIMITER ;




DELIMITER $$
CREATE PROCEDURE usp_take_loan  (IN customer_id INT, IN loan_amount DECIMAL(10,2),IN interest DECIMAL(4,2),IN start_date DATE)
BEGIN
START TRANSACTION;
INSERT INTO loans(start_date, amount,interest,expiration_date,customer_id)
VALUES(start_date,loan_amount,interest,NULL,customer_id);
IF	loan_amount NOT BETWEEN 0.01 AND 100000 THEN
ROLLBACK;
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Invalid Loan Amount.';
END IF;
COMMIT;
END$$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER trigger_hire
AFTER INSERT 
ON employees 
FOR EACH ROW 
BEGIN 
UPDATE employees_loans 
SET employees_loans.employee_id=NEW.employee_id
WHERE employees_loans.employee_id=(SELECT * FROM (SELECT MAX(ela.employee_id) FROM employees_loans AS ela) AS p);
END$$
DELIMITER ;


SELECT el.loan_id FROM employees_loans AS el
WHERE el.employee_id = (SELECT MAX(ela.) FROM employees AS ela);

SELECT MAX(ela.employee_id) FROM employees AS ela
ORDER BY ela.hire_date DESC
LIMIT 1;

SELECT ela.employee_id FROM employees AS ela 
ORDER BY ela.hire_date DESC limit 1