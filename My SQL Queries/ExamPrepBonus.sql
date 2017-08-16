DELIMITER $$
CREATE FUNCTION udf_get_radians (degrees FLOAT)
RETURNS FLOAT
BEGIN
DECLARE outcome FLOAT;
SET outcome := degrees * PI()/180;
RETURN outcome;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE udp_change_password (IN email VARCHAR(30),IN password VARCHAR(30))
BEGIN
IF (SELECT COUNT(c.email)  FROM credentials AS c WHERE c.email=email)<>1 THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "The email does't exist!";
END IF;
UPDATE credentials AS c
SET c.password:=password
WHERE c.email=email;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE udp_send_message (IN user_id INT,IN chat_id INT, IN content VARCHAR(200))
BEGIN
IF (SELECT COUNT(u.id) FROM users AS u WHERE u.id=user_id)<>1 THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "There is no chat with that user!";
END IF;
INSERT INTO messages(content,sent_on,chat_id,user_id)
VALUES(content,'2016-12-15',chat_id,user_id);
END$$
DELIMITER ;



DELIMITER $$
CREATE TRIGGER any_trigger
AFTER DELETE 
ON messages
FOR EACH ROW 
BEGIN 
INSERT INTO messages_log(id,content,sent_on,chat_id,user_id)
VALUES(OLD.id,OLD.content,OLD.sent_on,OLD.chat_id,OLD.user_id);
END$$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER delete_trigger
BEFORE DELETE 
ON users
FOR EACH ROW 
BEGIN
DELETE uc FROM users_chats AS uc WHERE uc.user_id=OLD.id;
DELETE ml FROM messages_log AS ml WHERE ml.user_id=OLD.id;
DELETE m FROM messages AS m WHERE m.user_id=OLD.id;
END$$
DELIMITER ;




DELETE ml FROM messages_log AS ml WHERE 


SELECT u.location_id FROM users AS u WHERE u.id=1;

ALTER TABLE users_chats
DROP fk_user_id_users
DELETE FROM users WHERE users.id=1;

DELETE uc FROM users_chats AS uc WHERE uc.user_id=1;

DELETE l FROM locations  AS l WHERE l.id =19 IN (SELECT location_id FROM  (SELECT u.location_id FROM users AS u WHERE u.id=1) AS p);