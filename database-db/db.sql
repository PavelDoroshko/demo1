

CREATE TABLE PERSON(
                       id long NOT NULL AUTO_INCREMENT,
                       age INT,
                       name varchar,
                       sur_name varchar,
                       vacation_type varchar,
                       PRIMARY KEY (id)
);

CREATE TABLE CAT(
                    id long  NOT NULL AUTO_INCREMENT,
                    name varchar(40),
                    age INT,
                    person_id long,
                    PRIMARY KEY (id),
                    FOREIGN KEY (person_id) REFERENCES PERSON(id)
);
CREATE TABLE VOCATIONDAY(
                            id long NOT NULL AUTO_INCREMENT,
                            day DATE,
                            person_id long,
                            PRIMARY KEY (id),
                            FOREIGN KEY (person_id) REFERENCES PERSON(id)
);




INSERT INTO PERSON( age,name,sur_name,vacation_type)
values (25, 'Pavelyyyyyyyyyyyyyyyyyy', 'DDD','ILLNESS');
INSERT INTO PERSON( age,name,sur_name,vacation_type)
values (35, 'Sasha', 'lll',' EXCEPTION');
INSERT INTO PERSON( age,name,sur_name,vacation_type)
values (35, 'Olia', 'lll',' EXCEPTION');
INSERT INTO PERSON( age,name,sur_name,vacation_type)
values (35, 'ssss', 'lll',' EXCEPTION');

INSERT INTO CAT( name,age,person_id )
values ('est',2,1);
INSERT INTO CAT(name,age,person_id )
values ('aaaarrrrrrrrrrrrrrrrrr',3,1);
INSERT INTO CAT(name,age,person_id )
values ('xxxx',3,2);
INSERT INTO CAT( name,age,person_id )
values ('eeee',2,1);
INSERT INTO CAT( name,age,person_id )
values ('ttt',2,4);

INSERT INTO VOCATIONDAY( day,person_id )
values ('2022-1-1',1);
INSERT INTO VOCATIONDAY( day,person_id )
values ('2022-2-1',1);