CREATE TABLE customer_reviews (
	review_id INT(11) PRIMARY KEY,
	review_content VARCHAR(255),
	review_grade INT(11),
	airline_id INT(11),
	customer_id INT(11),
	CONSTRAINT fk_airlines_customer_reviews FOREIGN KEY (airline_id) REFERENCES airlines(airline_id),
	CONSTRAINT fk_customers_customer_reviews FOREIGN KEY (customer_id) REFERENCES customers(customer_id));

CREATE TABLE customer_bank_accounts(
	account_id INT(11) PRIMARY KEY,
	account_number VARCHAR(10),
	balance DECIMAL(10,2),
	customer_id INT(11),
	CONSTRAINT fk_customers_customer_bank_accounts FOREIGN KEY (customer_id) REFERENCES customers(customer_id)	 );
	

DELIMITER $$
CREATE PROCEDURE udp_submit_review (IN customer_id INT, IN review_content VARCHAR(255), IN review_grade INT, IN airline_name  VARCHAR(30))
BEGIN
DECLARE id INT(11);
IF airline_name NOT IN ( SELECT a.airline_name FROM airlines AS a) THEN
signal sqlstate '45000' set message_text = 'Airline does not exist';
ELSE 
SET id:= (SELECT a.airline_id FROM airlines AS a  WHERE a.airline_name=airline_name);
INSERT INTO  customer_reviews (review_content,review_grade,airline_id,customer_id)
VALUES(review_content,review_grade,id,customer_id);
END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE udp_purchase_ticket (IN customer_id INT, 
IN flight_id INT(11), IN ticket_price DECIMAL(10,2), IN class  VARCHAR(6),IN seat  VARCHAR(5))
BEGIN
START TRANSACTION;
INSERT INTO tickets(price,
	class ,
	seat ,
	customer_id ,
	flight_id )
VALUES(ticket_price,class,seat,customer_id,flight_id);
UPDATE customer_bank_accounts
SET balance:=balance-ticket_price WHERE customer_id=customer_id;

IF (SELECT cba.balance FROM customer_bank_accounts AS cba WHERE cba.customer_id=customer_id)<0
 THEN
signal sqlstate '45000' set message_text = 'Insufficient bank account balance for ticket purchase.';
ROLLBACK;
ELSE
COMMIT;
END IF;
END $$
DELIMITER ;

CREATE TABLE arrived_flights(
	flight_id INT PRIMARY KEY,
	arrival_time DATETIME,
	origin VARCHAR(50),
	destination VARCHAR(50),
	passengers INT)

DELIMITER $$
CREATE TRIGGER trigger_update
AFTER UPDATE 
ON flights 
FOR EACH ROW 
BEGIN 
IF	NEW.`status`='Arrived' THEN
INSERT INTO arrived_flights (flight_id,arrival_time,origin,destination,passengers)
VALUES(OLD.flight_id, OLD.arrival_time,
(SELECT a.airport_name FROM  airports AS a WHERE a.airport_id=OLD.origin_airport_id),
(SELECT a.airport_name FROM  airports AS a WHERE a.airport_id=OLD.destination_airport_id),
(SELECT COUNT(*) FROM  tickets AS a WHERE a.flight_id=OLD.flight_id));
END IF;
END$$
DELIMITER ;

SELECT COUNT(*) FROM  tickets AS a WHERE a.flight_id=15