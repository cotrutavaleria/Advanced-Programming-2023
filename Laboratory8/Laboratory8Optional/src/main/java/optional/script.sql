CREATE TABLE exported_albums (
    id            int AUTO_INCREMENT PRIMARY KEY,
    year          int DEFAULT NULL,
    album         varchar(200) DEFAULT NULL,
    artist        varchar(200) DEFAULT NULL,
    genre         varchar(200) DEFAULT NULL,
    subgenre      varchar(200) DEFAULT NULL
);

CREATE TABLE playlists (
    id                          int AUTO_INCREMENT PRIMARY KEY,
    name  						varchar(200) DEFAULT NULL,
    creation_timestamp          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE playlists_albums (
    id                          int AUTO_INCREMENT PRIMARY KEY,
    id_playlist                 int DEFAULT NULL,
    id_album                    int DEFAULT NULL
);
