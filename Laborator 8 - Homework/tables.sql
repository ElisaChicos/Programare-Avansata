drop table countries;

drop table continents;

drop table cities;

CREATE TABLE COUNTRIES
(
    id        INTEGER      not NULL,
    name      VARCHAR(100) not NULL,
    code      VARCHAR(100)  not NULL,
    continent VARCHAR(100)  not NULL,
    PRIMARY KEY (name)
);


CREATE TABLE CONTINENTS
(
    id   INTEGER     not NULL,
    name VARCHAR(40) not NULL,
    PRIMARY KEY (id)
);

CREATE TABLE CITIES
(
    id        INTEGER      not NULL,
    country   VARCHAR(100) not NULL,
    name      VARCHAR(100) not NULL,
    capital   INTEGER      not NULL
        constraint ch_capital check (capital in (0, 1)),
    latitude  DOUBLE PRECISION      not NULL,
    longitude DOUBLE PRECISION     not NULL,
    PRIMARY KEY (id)
);