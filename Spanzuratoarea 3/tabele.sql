drop table plante;

drop table animale;

drop table geografie;

drop table istorie;

drop table literatura;

drop table medicina;

CREATE TABLE MEDICINA
(
    id        INTEGER      not NULL,
    name      VARCHAR(100) not NULL,
    PRIMARY KEY (name)
);

CREATE TABLE LITERATURA
(
    id        INTEGER      not NULL,
    name      VARCHAR(100) not NULL,
    PRIMARY KEY (name)
);

CREATE TABLE ISTORIE
(
    id        INTEGER      not NULL,
    name      VARCHAR(100) not NULL,
    PRIMARY KEY (name)
);

CREATE TABLE GEOGRAFIE
(
    id        INTEGER      not NULL,
    name      VARCHAR(100) not NULL,
    PRIMARY KEY (name)
);

CREATE TABLE PLANTE
(
    id        INTEGER      not NULL,
    name      VARCHAR(100) not NULL,
    PRIMARY KEY (name)
);

CREATE TABLE ANIMALE
(
    id        INTEGER      not NULL,
    name      VARCHAR(100) not NULL,
    PRIMARY KEY (name)
);
