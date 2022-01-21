DROP TABLE IF EXISTS CAT;
DROP TABLE IF EXISTS PERSON;


CREATE TABLE CAT(
                     id long  NOT NULL AUTO_INCREMENT,
                     name varchar(40),
                     age INT
);
CREATE TABLE PERSON(
                      id long NOT NULL AUTO_INCREMENT,
                       name varchar,
                       surname varchar,
                       age INT
);
CREATE TABLE VOCATIONDAY(
                       id long NOT NULL AUTO_INCREMENT,
                       name varchar,
                       surname varchar,
                       age INT
);