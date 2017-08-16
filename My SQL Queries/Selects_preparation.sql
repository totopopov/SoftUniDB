SELECT t.ticket_id, t.price, t.class, t.seat  FROM tickets AS t 
ORDER BY t.ticket_id;


SELECT  c.customer_id, CONCAT(c.first_name,' ',c.last_name) AS full_name, c.gender FROM  customers AS c 
ORDER BY full_name, c.customer_id;

SELECT f.flight_id, f.departure_time, f.arrival_time FROM flights AS f 
WHERE f.`status`="Delayed" 
ORDER BY f.flight_id;

SELECT a.airline_id, a.airline_name, a.nationality, a.rating FROM airlines AS a, flights AS f
where a.airline_id IN (f.airline_id)
GROUP BY a.airline_id
ORDER BY a.rating DESC
LIMIT 5;

SELECT t.ticket_id, a.airport_name AS destination, CONCAT(c.first_name,' ',c.last_name) AS customer_name FROM 
tickets AS t
INNER JOIN customers AS c ON c.customer_id=t.customer_id
INNER JOIN flights AS f ON t.flight_id=f.flight_id
INNER JOIN airports as a ON f.destination_airport_id=a.airport_id
WHERE t.price<5000 AND t.class="First"
ORDER BY t.ticket_id;


SELECT c.customer_id,  CONCAT(c.first_name,' ',c.last_name) AS full_name, t.town_name  AS home_town FROM  customers AS c 
INNER JOIN towns AS t ON t.town_id=c.home_town_id
INNER JOIN tickets AS ti ON c.customer_id=ti.customer_id
INNER JOIN flights AS f ON ti.flight_id=f.flight_id
INNER JOIN airports AS a ON a.airport_id=f.origin_airport_id
WHERE c.home_town_id=a.town_id AND f.`status`="Departing"
GROUP BY c.customer_id;


SELECT c.customer_id,  CONCAT(c.first_name,' ',c.last_name) AS full_name, 2016-YEAR(c.date_of_birth) AS age FROM  customers AS c
INNER JOIN tickets AS t ON c.customer_id=t.customer_id
INNER JOIN flights AS f ON t.flight_id=f.flight_id
WHERE f.`status`="Departing"
GROUP BY c.customer_id
ORDER BY age,c.customer_id;


SELECT c.customer_id,  CONCAT(c.first_name,' ',c.last_name), t.price, a.airport_name
 FROM  customers AS c
INNER JOIN tickets AS t ON c.customer_id=t.customer_id
INNER JOIN flights AS f ON t.flight_id=f.flight_id
INNER JOIN airports AS a ON f.destination_airport_id=a.airport_id
WHERE f.`status`="Delayed" 
ORDER BY t.price DESC, c.customer_id
LIMIT 3;

SELECT p.flight_id, p.departure_time, p.arrival_time,p.origin,p.destination FROM 
(SELECT f.flight_id AS flight_id, f.departure_time AS departure_time, f.arrival_time AS arrival_time, a1.airport_name AS origin,  a2.airport_name AS destination FROM flights AS f 
INNER JOIN airports AS a1 ON a1.airport_id=f.origin_airport_id 
INNER JOIN airports AS a2 ON a2.airport_id=f.destination_airport_id
WHERE f.`status`="Departing"
ORDER BY f.departure_time DESC , f.flight_id DESC 
LIMIT 5) AS p
ORDER BY p.departure_time , p.flight_id ;


SELECT c.customer_id, CONCAT(c.first_name,' ',c.last_name), (2016-YEAR(c.date_of_birth)) AS `age` FROM customers AS c
INNER JOIN tickets AS t ON t.customer_id=c.customer_id
INNER JOIN flights AS f ON f.flight_id=t.flight_id
WHERE f.`status`="Arrived" AND (2016-YEAR(c.date_of_birth)) <21
GROUP BY c.customer_id
ORDER BY age DESC, c.customer_id; 



SELECT a.airport_id, a.airport_name, COUNT(t.ticket_id) AS passengers  FROM airports AS a 
INNER JOIN flights AS f1 ON f1.origin_airport_id=a.airport_id AND f1.`status`="Departing"
INNER JOIN tickets AS t ON t.flight_id=f1.flight_id
GROUP BY a.airport_id, a.airport_name 
HAVING passengers>0 
ORDER BY a.airport_id




