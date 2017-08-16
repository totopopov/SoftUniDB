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
RETURNS INT
BEGIN
DECLARE outcome INT DEFAULT 0;
DECLARE i INT DEFAULT 0;
WHILE (i<CHARACTER_LENGTH(word)) DO
SET outcome:=outcome+IF(INSTR(set_of_letters,SUBSTRING(word,i+1,1))>0,1,0);
SET i:=i+1;
END WHILE;
RETURN IF(outcome=CHARACTER_LENGTH(word),1,0);
END $$
DELIMITER ;


SELECT SUBSTRING('1234',0+2,1)

