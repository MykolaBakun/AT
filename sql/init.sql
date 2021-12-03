Use test;
CREATE TABLE `user` (
    `id` int NOT NULL AUTO_INCREMENT,
    `login` varchar(45) DEFAULT NULL,
    `pass` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
)