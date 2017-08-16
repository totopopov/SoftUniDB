CREATE TABLE `cities`(
		city_id INT(11) PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(50));

CREATE TABLE `customers`(
		customer_id INT(11) PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(50),
		birthday DATE,
		city_id INT(11),
		CONSTRAINT fk_cities FOREIGN KEY (city_id) REFERENCES cities(city_id)
		);
		
CREATE TABLE `orders`(
		order_id INT(11) PRIMARY KEY AUTO_INCREMENT,
		customer_id INT(11),
		CONSTRAINT fk_customers FOREIGN KEY (customer_id) REFERENCES customers(customer_id) 
		);

CREATE TABLE `item_types`(
		item_type_id INT(11) PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(50));

CREATE TABLE `items`(
		item_id INT(11) PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(50),
		item_type_id INT(11),
		CONSTRAINT fk_item_type FOREIGN KEY (item_type_id) REFERENCES item_types(item_type_id)
		);
	
	
CREATE TABLE `order_items`(
		order_id INT(11),
		item_id INT(11),
		CONSTRAINT pk_order_items PRIMARY KEY (order_id,item_id) ,
		CONSTRAINT fk_item_id FOREIGN KEY (item_id) REFERENCES items(item_id),
		CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES orders(order_id)
		);		
		
		
		
************************************************************************************************************************************

CREATE TABLE `subjects`(
		subject_id INT(11) PRIMARY KEY AUTO_INCREMENT,
		subject_name VARCHAR(50));
		
CREATE TABLE `majors`(
		major_id INT(11) PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(50));

CREATE TABLE `students`(
		student_id INT(11) PRIMARY KEY AUTO_INCREMENT,
		student_number VARCHAR(12),
		student_name VARCHAR(50),
		major_id INT(11),
		CONSTRAINT fk_majors FOREIGN KEY (major_id) REFERENCES majors(major_id)
		);

CREATE TABLE `payments`(
		payment_id INT(11) PRIMARY KEY AUTO_INCREMENT,
		payment_date DATE,
		payment_amount DECIMAL(8,2),
		student_id INT(11),
		CONSTRAINT fk_students FOREIGN KEY (student_id) REFERENCES students(student_id)
		);
		
CREATE TABLE `agenda`(
		student_id INT(11),
		subject_id INT(11),
		CONSTRAINT pk_student_subject PRIMARY KEY(student_id,subject_id),
	   CONSTRAINT fk_student FOREIGN KEY(student_id) REFERENCES students(student_id),
		CONSTRAINT fk_subject FOREIGN KEY(subject_id) REFERENCES subjects(subject_id)
		);
		

************************************************************************************************************************************


SELECT m.mountain_range AS 'mountain_range',p.peak_name AS 'peak_name', p.elevation AS 'peak_elevation' FROM mountains AS m
JOIN peaks AS p ON m.id=p.mountain_id
WHERE m.mountain_range='Rila'
ORDER BY peak_elevation DESC;

