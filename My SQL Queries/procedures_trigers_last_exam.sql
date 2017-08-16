DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000 ()
BEGIN
SELECT e.first_name,e.last_name FROM employees AS e 
WHERE e.salary>35000
ORDER BY e.first_name, e.last_name;
END $$
DELIMITER ;

CALL usp_get_employees_salary_above_35000;

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above  (IN treshold DECIMAL(19,4))
BEGIN
SELECT e.first_name,e.last_name FROM employees AS e 
WHERE e.salary>=treshold
ORDER BY e.first_name, e.last_name;
END $$
DELIMITER ;

CALL usp_get_employees_salary_above();

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(IN town_letter VARCHAR(20))
BEGIN
SELECT t.name FROM towns AS t 
WHERE LEFT(t.name,CHARACTER_LENGTH(town_letter))=town_letter
ORDER BY t.name;
END $$
DELIMITER ;

CALL usp_get_towns_starting_with('b')

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town (IN town_name VARCHAR(20))
BEGIN
SELECT e.first_name,e.last_name FROM employees AS e
INNER JOIN addresses AS a ON a.address_id=e.address_id
INNER JOIN towns AS t ON a.town_id=t.town_id
WHERE t.name=town_name
ORDER BY e.first_name,e.last_name;
END $$
DELIMITER ;

CALL usp_get_employees_from_town('Sofia');

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level (salary DECIMAL(19,4))
RETURNS VARCHAR(10)
BEGIN
DECLARE outcome VARCHAR(10);
IF salary<30000 THEN
SET outcome :='Low';
ELSEIF salary<=50000 THEN 
SET outcome:='Average';
ELSE
SET outcome ='High';
END IF;
RETURN outcome;
END $$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level_ternar (salary DECIMAL(19,4))
RETURNS VARCHAR(10)
BEGIN
DECLARE outcome VARCHAR(10);
SET outcome:=IF(salary<30000,'Low',IF(salary<=50000,'Average','High'));
RETURN outcome;
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level (IN salary_level VARCHAR(10))
BEGIN
IF salary_level='low' THEN
SELECT e.first_name, e.last_name FROM employees AS e 
WHERE e.salary<30000 ORDER BY e.first_name DESC, e.last_name DESC ;
ELSEIF salary_level='average' THEN
SELECT e.first_name, e.last_name FROM employees AS e 
WHERE e.salary BETWEEN 30000 AND 50000  ORDER BY e.first_name DESC, e.last_name DESC ;
ELSEIF salary_level='high' THEN
SELECT e.first_name, e.last_name FROM employees AS e
WHERE e.salary > 50000  ORDER BY e.first_name DESC, e.last_name DESC ;
END IF;
END $$
DELIMITER ;



DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(20), word VARCHAR(25))
RETURNS BOOL
BEGIN
DECLARE outcome BOOL DEFAULT 0;
DECLARE i INT DEFAULT 0;
WHILE (i<CHARACTER_LENGTH(word)) DO
SET outcome:=outcome+IF(INSTR(set_of_letters,SUBSTRING(word,i+1,1))>0,1,0);
SET i:=i+1;
END WHILE;
RETURN IF(outcome=CHARACTER_LENGTH(word),1,0);
END $$
DELIMITER ;


UPDATE employees AS e 
INNER JOIN employees as p ON
e.manager_id=p.employee_id
SET e.manager_id = NULL 
WHERE p.department_id IN (7,8);

DELETE FROM employees_projects
WHERE employee_id IN (SELECT e.employee_id FROM employees AS e WHERE e.department_id IN (7,8));

SELECT * FROM employees;


ALTER TABLE employees DROP FOREIGN KEY fk_employees_addresses;
ALTER TABLE employees DROP FOREIGN KEY fk_employees_departments;
ALTER TABLE employees DROP FOREIGN KEY  fk_employees_employees;
ALTER TABLE departments DROP FOREIGN KEY fk_departments_employees;
ALTER TABLE employees_projects DROP FOREIGN KEY fk_employees_projects_employees;
DELETE FROM employees WHERE department_id IN (7,8);
DELETE FROM departments WHERE department_id IN (7,8);

SELECT * FROM employees_projects AS ep
ORDER BY ep.employee_id;

SELECT SUBSTRING('1234',0+2,1)



DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
SELECT CONCAT(ah.first_name,' ',ah.last_name) AS full_name 
FROM account_holders AS ah
ORDER BY full_name;
END $$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(IN number DECIMAL(19,4))
BEGIN
SELECT ah.first_name,ah.last_name
FROM account_holders AS ah
INNER JOIN (SELECT a.account_holder_id, SUM(a.balance) AS balance
FROM accounts AS a
GROUP BY a.account_holder_id) AS bal ON ah.id=bal.account_holder_id
WHERE bal.balance>=number
ORDER BY ah.first_name,ah.last_name;
END $$
DELIMITER ;





DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value (sumOfM DECIMAL(19,4) , interest DECIMAL(19,4), years DECIMAL(19,4))
RETURNS DECIMAL(19,2)
BEGIN
DECLARE outcome DECIMAL(19,4) DEFAULT 0;
SET outcome:= sumOfM*POWER((1+interest),years);
RETURN outcome;
END $$
DELIMITER ;



DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value (sumOfM DECIMAL(19,4) , interest DECIMAL(19,4), years DECIMAL(19,4))
RETURNS DECIMAL(19,4)
BEGIN
DECLARE outcome DECIMAL(19,4) DEFAULT 0;
SET outcome:= sumOfM*POWER((1+interest),years);
RETURN outcome;
END;


CREATE PROCEDURE usp_calculate_future_value_for_account(IN account_id INT,interest DECIMAL(19,4))
BEGIN
SELECT a.id, ah.first_name, ah.last_name, a.balance AS current_balance, ufn_calculate_future_value(a.balance,interest,5) AS balance_in_5_years  FROM accounts AS a 
INNER JOIN account_holders AS ah ON ah.id=a.account_holder_id
WHERE a.id=account_id;
END $$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE usp_deposit_money(IN account_id INT, IN money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
UPDATE accounts AS a SET a.balance= a.balance+money_amount WHERE a.id=account_id;
IF money_amount < 0.0 THEN ROLLBACK;
ELSEIF (SELECT COUNT(a.id) FROM accounts AS a WHERE a.id=account_id) <> 1 THEN ROLLBACK;
END IF;
COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money (IN account_id INT, IN money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
UPDATE accounts AS a SET a.balance= a.balance-money_amount WHERE a.id=account_id;
IF money_amount < 0.0 THEN ROLLBACK;
ELSEIF (SELECT COUNT(a.id) FROM accounts AS a WHERE a.id=account_id) <> 1 THEN ROLLBACK;
ELSEIF (SELECT a.balance FROM accounts AS a WHERE a.id=account_id) <0 THEN ROLLBACK;
END IF;
COMMIT;
END $$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE usp_transfer_money (IN from_account_id INT, IN to_account_id INT, IN money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;

UPDATE accounts AS a SET a.balance= a.balance-money_amount WHERE a.id=from_account_id;
UPDATE accounts AS a SET a.balance= a.balance+money_amount WHERE a.id=to_account_id;

IF money_amount <= 0 THEN ROLLBACK;
ELSEIF (SELECT COUNT(a.id) FROM accounts AS a WHERE a.id=from_account_id) <> 1 THEN ROLLBACK;
ELSEIF (SELECT COUNT(a.id) FROM accounts AS a WHERE a.id=to_account_id) <> 1 THEN ROLLBACK;
ELSEIF (SELECT a.balance FROM accounts AS a WHERE a.id=from_account_id) < money_amount THEN ROLLBACK;
ELSEIF from_account_id=to_account_id THEN ROLLBACK;
END IF;

COMMIT;
END $$
DELIMITER ;


CREATE TABLE logs(
		log_id INT PRIMARY KEY AUTO_INCREMENT,
		account_id INT,
		old_sum DECIMAL(19,4),
		new_sum DECIMAL(19,4));


SELECT a.balance FROM accounts AS a;

DELIMITER $$

CREATE TABLE logs(
		log_id INT PRIMARY KEY AUTO_INCREMENT,
		account_id INT,
		old_sum DECIMAL(19,4),
		new_sum DECIMAL(19,4));

CREATE TRIGGER create_new_email
AFTER UPDATE 
ON accounts 
FOR EACH ROW 
BEGIN 
INSERT INTO logs (account_id,old_sum,new_sum)
VALUES(NEW.id, OLD.balance,NEW.balance);
END $$
DELIMITER ;


SELECT l.old_sum FROM `logs` AS l ;

DELIMITER $$
CREATE TABLE logs(
		log_id INT PRIMARY KEY AUTO_INCREMENT,
		account_id INT,
		old_sum DECIMAL(19,4),
		new_sum DECIMAL(19,4));
		
		CREATE TRIGGER create_new_email
AFTER UPDATE 
ON accounts 
FOR EACH ROW 
BEGIN 
INSERT INTO logs (account_id,old_sum,new_sum)
VALUES(NEW.id, OLD.balance,NEW.balance);
END ;

CREATE TABLE notification_emails(
		id  INT PRIMARY KEY AUTO_INCREMENT,
		recipient  INT,
		subject VARCHAR(100),
		body VARCHAR(100));


CREATE TRIGGER create_old_email
AFTER INSERT 
ON `logs`
FOR EACH ROW 
BEGIN 
INSERT INTO notification_emails(recipient,subject,body)
VALUES(NEW.account_id,CONCAT('Balance change for account: ',NEW.account_id), 
CONCAT('On ',DATE_FORMAT(NOW(),'%b %e %Y at %r'),' your balance was changed from ',NEW.old_sum,' to ',NEW.new_sum,'.'));
END $$
DELIMITER ;