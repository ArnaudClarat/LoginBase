DROP DATABASE IF EXISTS `5ipoo`;

CREATE DATABASE `5ipoo`;
USE `5ipoo`;
CREATE TABLE users (
                       PK_Utilisateur smallint unsigned not null auto_increment,
                       U_Login char(6) not null,
                       U_Pass char(32) not null,
                       constraint primary key (PK_Utilisateur)
);