-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.18-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for school
CREATE DATABASE IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `school`;

-- Dumping structure for table school.classes
CREATE TABLE IF NOT EXISTS `classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `max_students` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table school.classes: ~4 rows (approximately)
DELETE FROM `classes`;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` (`id`, `name`, `max_students`) VALUES
	(1, '!0V', 29),
	(2, '1a', 20),
	(3, '1b', 13),
	(4, '1c', 15);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;

-- Dumping structure for table school.students
CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `phone_number` char(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table school.students: ~4 rows (approximately)
DELETE FROM `students`;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`id`, `name`, `age`, `phone_number`) VALUES
	(1, 'Todor', 12, '359883350131'),
	(2, 'Katrin', 27, '359883305186'),
	(3, 'Pesho', 27, '359883307598'),
	(4, 'Gosho', 27, '359883305189');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;

-- Dumping structure for table school.teachers
CREATE TABLE IF NOT EXISTS `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pfk_classes` (`class_id`),
  CONSTRAINT `pfk_classes` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table school.teachers: ~1 rows (approximately)
DELETE FROM `teachers`;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` (`id`, `name`, `class_id`) VALUES
	(1, 'Maria', 1);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
