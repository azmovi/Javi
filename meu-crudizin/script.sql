CREATE DATABASE IF NOT EXISTS users;

USE users;

CREATE TABLE IF NOT EXISTS `user` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255) NOT NULL,
    `senha` VARCHAR(255) NOT NULL,
    `idade` INT NOT NULL
);

INSERT INTO `user` (`nome`, `senha`, `idade`) VALUES ('Buenao', 'senha123', 17);
