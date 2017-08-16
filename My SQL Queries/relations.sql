CREATE TABLE `passports` (
	passport_id INT PRIMARY KEY AUTO_INCREMENT,
	passport_number VARCHAR(8)
	);

ALTER TABLE `passports` 
AUTO_INCREMENT=101;

CREATE TABLE `persons` (
	person_id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(8),
	salary DECIMAL(10,2),
	passport_id INT UNIQUE,
	CONSTRAINT fk_passport_id FOREIGN KEY (passport_id) REFERENCES passports(passport_id)
	);
	
INSERT INTO passports(passport_number)
VALUES('N34FG21B'),('K65LO4R7'),('ZE657QP2');

INSERT INTO persons(first_name,salary,passport_id)
VALUES('Roberto',43300.00,102),('Tom',56100.00,103),('Yana',60200.00,101);





CREATE TABLE `manufacturers`(
	manufacturer_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(19),
	established_on DATE
	);


CREATE TABLE `models`(
	model_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(19),
	manufacturer_id INT,
	CONSTRAINT fk_manufacturers FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(manufacturer_id)
	);

ALTER TABLE models AUTO_INCREMENT=101;

INSERT INTO manufacturers(name,established_on)
VALUES ('BMW','1916-03-01'),('Tesla','2003-01-01'),('Lada','1966-05-01');

INSERT INTO models(name,manufacturer_id)
VALUES ('X1',1),('i6',1),('Model S',2),('Model X',2),('Model 3',2),('Nova',3);




CREATE TABLE `students`(
	student_id INT PRIMARY KEY AUTO_INCREMENT, 
	name VARCHAR(20) NOT NULL
	);

CREATE TABLE `exams`(
	exam_id INT PRIMARY KEY AUTO_INCREMENT, 
	name VARCHAR(20) NOT NULL
	);
	
ALTER TABLE `exams` AUTO_INCREMENT=101;

CREATE TABLE `students_exams`(
	student_id INT NOT NULL, 
	exam_id INT NOT NULL,
	CONSTRAINT PRIMARY KEY (student_id,exam_id),
	CONSTRAINT fk_students FOREIGN KEY(student_id) REFERENCES students(student_id),
	CONSTRAINT FK_exams FOREIGN KEY(exam_id) REFERENCES exams(exam_id)
	);

INSERT INTO students(name)
VALUES ('Mila'),('Toni'),('Ron');

INSERT INTO exams(name)
VALUES ('Spring MVC'),('Neo4j'),('Oracle 11g');

INSERT INTO students_exams(student_id,exam_id)
VALUES (1,101),(1,102),(2,101),(3,103),(2,102),(2,103);



CREATE TABLE `teachers`(
		teacher_id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(20), 
		manager_id INT NULL
		);
ALTER TABLE teachers AUTO_INCREMENT=101;

INSERT INTO teachers(teacher_id,name,manager_id)
VALUES (101,'John',NULL),(102,'Maya',106),(103,'Silvia',106),(104,'Ted',105),(105,'Mark',101),(106,'Greta',101);

ALTER TABLE teachers
ADD CONSTRAINT fk_selfRef FOREIGN KEY (manager_id) REFERENCES teachers(teacher_id);




CREATE TABLE `teachers`(
		teacher_id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(20), 
		manager_id INT NULL,
		CONSTRAINT fk_selfRef FOREIGN KEY (manager_id) REFERENCES teachers(teacher_id)
		);
ALTER TABLE teachers AUTO_INCREMENT=101;

INSERT INTO teachers(teacher_id,name,manager_id)
VALUES (101,'John', NULL),(102,'Maya',106),(103,'Silvia',106),(104,'Ted',105),(105,'Mark',101),(106,'Greta',101);



