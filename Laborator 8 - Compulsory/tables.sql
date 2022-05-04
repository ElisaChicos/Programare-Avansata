drop table cities;

drop table continents;


CREATE TABLE CITIES(id INTEGER not NULL,
                   name VARCHAR(100) not NULL,
                   code VARCHAR(10) not NULL,
                   continent VARCHAR(10) not NULL,
                   PRIMARY KEY ( id ));


CREATE TABLE CONTINENTS(id INTEGER not NULL,
                   name VARCHAR(40) not NULL,
                   PRIMARY KEY ( id ));
