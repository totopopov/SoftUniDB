SELECT u.nickname, u.gender, u.age FROM users AS u WHERE u.age BETWEEN 22 AND 37;

SELECT m.content, m.sent_on FROM messages AS m 
WHERE DATE(m.sent_on) > '2014-05-12' AND m.content 
LIKE '%just%' ORDER BY m.id DESC

SELECT c.title, c.is_active FROM chats AS c 
WHERE (c.is_active=0 AND CHARACTER_LENGTH(c.title)<5) OR  SUBSTR(c.title,3,2)='tl'
ORDER BY c.title DESC;

SELECT c.id, c.title,m.id FROM chats AS c
INNER JOIN messages AS m ON m.chat_id=c.id
WHERE RIGHT( c.title ,1)='x' AND DATE(m.sent_on)<'2012-03-26'
ORDER BY c.id,m.id;

SELECT c.id, COUNT(m.id) AS total_messages  FROM chats AS c
INNER JOIN messages AS m ON m.chat_id=c.id AND m.id<90
GROUP BY c.id
ORDER BY total_messages DESC, c.id
LIMIT 5;

SELECT u.nickname, c.email, c.password FROM credentials AS c 
INNER JOIN users AS u ON u.credential_id=c.id
WHERE RIGHT(c.email,5)='co.uk'
ORDER BY c.email;


SELECT u.id,u.nickname, u.age FROM users AS u 
WHERE u.location_id IS NULL 
ORDER BY u.id;

SELECT m.id, m.chat_id AS chat_id, m.user_id AS user_id  
FROM messages AS m
WHERE m.chat_id=17 AND  m.user_id NOT IN (SELECT uc.user_id FROM users_chats AS uc WHERE uc.chat_id=17)
ORDER BY m.id DESC;


SELECT m.id, c.id AS chat_id, u.id AS user_id  FROM messages AS m
LEFT JOIN chats AS c ON c.id=m.chat_id
LEFT JOIN users AS u ON u.id=m.user_id
LEFT JOIN users_chats AS uc ON uc.chat_id=17
WHERE (c.id=17 AND uc.user_id <> m.user_id) OR (m.user_id IS NULL AND c.id=17 )
ORDER BY m.id DESC;


SELECT u.nickname,c.title, l.latitude, l.longitude FROM users AS u
JOIN users_chats AS uc ON uc.user_id=u.id
JOIN chats AS c ON c.id=uc.chat_id  
JOIN locations AS l ON l.id=u.location_id
WHERE l.latitude >= 41.139999 AND l.latitude <= 44.129999 AND l.longitude >= 22.209999 AND l.longitude <=28.359999
ORDER BY c.title 


SELECT c.title FROM chats AS c 
ORDER BY c.start_date DESC 
LIMIT 1;

SELECT c.title,m.content FROM chats AS c 
LEFT JOIN messages AS m ON m.chat_id=c.id
WHERE c.title=(SELECT c.title FROM chats AS c 
ORDER BY c.start_date DESC 
LIMIT 1)
ORDER BY m.sent_on, m.id 





DELIMITER $$
CREATE FUNCTION udf_get_radians (degrees FLOAT)
RETURNS FLOAT
BEGIN
DECLARE outcome FLOAT;
SET outcome := degrees * PI()/180;
RETURN outcome;
END$$
DELIMITER ;