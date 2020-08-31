DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS specialists;
CREATE TABLE `tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `specialist_id` int NOT NULL,
  `serial_number` varchar(45) NOT NULL,
  `start_time` datetime DEFAULT NULL ,
  `end_time` datetime DEFAULT NULL,
   `state`enum('CANCELLED','WAITING','SERVING', 'END') NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `serial_number_UNIQUE` (`serial_number`)
);
CREATE TABLE `specialists` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `speciality`enum('ADMIN','ACCOUNTANT','MANAGER','SUPPORT') NOT NULL,
  `role`enum('ADMIN','CUSTOMER','WORKER'),
  PRIMARY KEY (`id`)
);