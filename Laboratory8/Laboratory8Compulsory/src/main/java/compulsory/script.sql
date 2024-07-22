CREATE DATABASE laborator8PA;
SHOW TABLES;
USE laborator8PA;

CREATE TABLE albums (
    id            int AUTO_INCREMENT PRIMARY KEY,
    release_year  int DEFAULT NULL,
    title         varchar(50) DEFAULT NULL,
    artist        varchar(50) DEFAULT NULL
);

CREATE TABLE artists (
	id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL
);

CREATE TABLE genres (
    id           int AUTO_INCREMENT PRIMARY KEY,
    name         varchar(50) DEFAULT NULL
);

CREATE TABLE album_genre (
    id          int NOT NULL,
    id_album    int NOT NULL,
    id_genre    int NOT NULL
);
SELECT * FROM albums;

DROP TABLE artists;
SET SQL_SAFE_UPDATES = 0;
DELETE FROM artists;
SET SQL_SAFE_UPDATES = 1;

