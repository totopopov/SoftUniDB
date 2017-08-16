DELIMITER $$
CREATE TRIGGER trigger_update
BEFORE UPDATE 
ON flights 
FOR EACH ROW 
BEGIN 
IF	NEW.status='Arrived' AND (OLD.status='Departing' OR OLD.status='Delayed') THEN
INSERT INTO arrived_flights (flight_id,arrival_time,origin,destination,passengers)
VALUE(NEW.flight_id, NEW.arrival_time,
(SELECT a.airport_name FROM  airports AS a WHERE a.airport_id=NEW.origin_airport_id),
(SELECT a.airport_name FROM  airports AS a WHERE a.airport_id=NEW.destination_airport_id),
(SELECT COUNT(*) FROM  tickets AS a WHERE a.flight_id=NEW.flight_id));
END IF;
END$$
DELIMITER ;