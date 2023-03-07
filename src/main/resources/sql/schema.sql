CREATE SCHEMA 'auros_test';
USE 'auros_test';

CREATE TABLE `k_pac` (
    `id` int NOT NULL AUTO_INCREMENT,
    `title` varchar(250) NOT NULL,
    `description` varchar(2000) NOT NULL,
    `creation_date` varchar(10) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `k_pac_set` (
    `id` int NOT NULL AUTO_INCREMENT,
    `title` varchar(250) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `k_pac_k_pac_set` (
     `id` int NOT NULL AUTO_INCREMENT,
     `k_pac_id` int NOT NULL,
     `k_pac_set_id` int NOT NULL,
      PRIMARY KEY (`id`),
      UNIQUE KEY `id_UNIQUE` (`id`),
      KEY `k_pac_id_idx` (`k_pac_id`),
      KEY `k_pac_set_id_idx` (`k_pac_set_id`),
      CONSTRAINT `k_pac_id` FOREIGN KEY (`k_pac_id`) REFERENCES `k_pac` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
      CONSTRAINT `k_pac_set_id` FOREIGN KEY (`k_pac_set_id`) REFERENCES `k_pac_set` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
