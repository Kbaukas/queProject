DROP TABLE IF EXISTS buildings;
DROP TABLE IF EXISTS owners;
CREATE TABLE `buildings` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `city` varchar(45) NOT NULL,
                             `street` varchar(45) NOT NULL,
                             `number` varchar(45) NOT NULL,
                             `owner_Id` bigint NOT NULL,
                             `size` double NOT NULL,
                             `market_value` decimal(10,2) NOT NULL,
                             `type` enum('APARTMENT','HOUSE','INDUSTRIAL') NOT NULL,
                             PRIMARY KEY (`id`)
);
CREATE TABLE `owners` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `first_name` varchar(45) NOT NULL,
                          `last_name` varchar(45) NOT NULL,
                          PRIMARY KEY (`id`)
);
