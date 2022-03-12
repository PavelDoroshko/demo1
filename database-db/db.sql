

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





INSERT INTO person ( age,name,sur_name)
values (25, 'Pavelyyyyyyyyyyyyyyyyyy', 'DDD');
INSERT INTO person ( age,name,sur_name)
values (35, 'Sasha', 'lll');
INSERT INTO person ( age,name,sur_name)
values (35, 'Olia', 'lll');
INSERT INTO person ( age,name,sur_name)
values (35, 'ssss', 'lll');

INSERT INTO cat ( name,age,person_id )
values ('est',2,1);
INSERT INTO cat (name,age,person_id )
values ('aaaarrrrrrrrrrrrrrrrrr',3,1);
INSERT INTO cat (name,age,person_id )
values ('xxxx',3,2);
INSERT INTO cat ( name,age,person_id )
values ('eeee',2,1);
INSERT INTO cat ( name,age,person_id )
values ('ttt',2,4);

