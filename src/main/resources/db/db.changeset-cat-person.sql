drop table if exists person cascade;
drop table if exists cat cascade;



CREATE TABLE IF NOT EXISTS person (
                                      id bigserial NOT NULL,
                                      age INT,
                                      name varchar,
                                      sur_name varchar,
                                      PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS cat (
                                   id  bigserial NOT NULL,
                                   name varchar(40),
                                   age INT,
                                   person_id bigint,
                                   PRIMARY KEY (id),
                                  FOREIGN KEY (person_id) REFERENCES PERSON(id)
    );