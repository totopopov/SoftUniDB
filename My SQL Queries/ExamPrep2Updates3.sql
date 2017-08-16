INSERT INTO messages(content,sent_on,chat_id,user_id)


SELECT 
CONCAT(u.age,'-',u.gender,'-',l.latitude,'-',l.longitude),
'2016-12-15',
CEIL(IF(u.gender ='F',SQRT(u.age*2), POW(u.age/18,3))),
u.id
 FROM users AS u
INNER JOIN locations as l ON l.id=u.location_id
WHERE u.id BETWEEN 10 AND 20;