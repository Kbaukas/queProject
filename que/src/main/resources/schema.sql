DROP TABLE IF EXISTS tickets;
CREATE TABLE `tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(45) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `serial_number_UNIQUE` (`serial_number`)
);