DELIMITER $$
CREATE PROCEDURE udp_login  (IN username VARCHAR(30), IN password VARCHAR(30) )
BEGIN

IF (SELECT COUNT(u.username) FROM users AS u WHERE u.username=username)<>1
THEN 
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Username does not exist!';
END IF;
IF (SELECT COUNT(u.username) FROM users AS u WHERE u.username=username AND u.password=password)<>1
THEN 
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Password is incorrect!';
END IF;
IF (SELECT COUNT(liu.username) FROM logged_in_users AS liu WHERE liu.username=username)<>0
THEN 
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'User is already logged in!';
END IF;

INSERT INTO logged_in_users()
SELECT * FROM users AS u WHERE u.username=username AND u.password=password;
END $$
DELIMITER ;









DELIMITER $$
CREATE PROCEDURE udp_evaluate   (IN id INT)
BEGIN
IF (SELECT COUNT(s.id) FROM submissions AS s WHERE s.id=id)<>1
THEN 
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Submission does not exist!';
END IF;

INSERT INTO evaluated_submissions()
SELECT s.id, p.name,  u.username, CEIL((p.points/ p.tests) * s.passed_tests) FROM submissions AS s
INNER JOIN problems AS p ON p.id = s.problem_id
INNER JOIN users AS u ON s.user_id=u.id
WHERE s.id=id;

END$$
DELIMITER ;



DELIMITER $$
CREATE TRIGGER trigger_update
BEFORE INSERT 
ON problems 
FOR EACH ROW 
BEGIN 

IF (SELECT LOCATE(' ',NEW.name))=0
THEN 
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'The given name is invalid!';
END IF;

IF NEW.points<=0
THEN 
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'The problem’s points cannot be less or equal to 0!';
END IF;

IF NEW.tests<=0
THEN 
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'The problem’s tests cannot be less or equal to 0!';
END IF;


END$$
DELIMITER ;

