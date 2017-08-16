DELETE FROM locations 
WHERE id NOT IN(SELECT u.location_id FROM users AS u WHERE u.location_id  IS NOT NULL)
;

