Use aqa_itstep;
DROP TABLE IF EXISTS address;
CREATE TABLE `address` (
                           `county` varchar(45) NOT NULL,
                           `city` varchar(45) NOT NULL,
                           `street` varchar(45) NOT NULL,
                           `building_number` int NOT NULL,
                           `address_id` int NOT NULL AUTO_INCREMENT,
                           PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS student;
CREATE TABLE `student` (
                           `student_id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(45) DEFAULT NULL,
                           `address_id` int DEFAULT NULL,
                           `age` int DEFAULT NULL,
                           `card_id` int DEFAULT NULL,
                           PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS department;
CREATE TABLE `department` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `name` varchar(45) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS card;
CREATE TABLE `card` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `student_id` int DEFAULT NULL,
                        `code` varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;