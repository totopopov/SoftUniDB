SELECT * FROM airlines AS a
ORDER BY a.rating DESC;

UPDATE tickets AS t
INNER JOIN flights AS f
ON f.flight_id=t.flight_id
SET t.price=t.price*1.5 
WHERE f.airline_id=3