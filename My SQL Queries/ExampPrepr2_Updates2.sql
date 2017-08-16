UPDATE chats as c
INNER JOIN messages AS m ON c.id=m.chat_id
SET c.start_date=m.sent_on
WHERE c.start_date>m.sent_on;


SELECT c.start_date,m.sent_on FROM chats AS c
INNER JOIN messages AS m ON c.id=m.chat_id
WHERE c.start_date>m.sent_on