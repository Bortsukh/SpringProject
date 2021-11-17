DROP TABLE IF EXISTS BREED;
CREATE TABLE BREED(BREED_ID BIGINT PRIMARY KEY, NAME_BREED VARCHAR(255));
DROP TABLE IF EXISTS ANIMAL;
CREATE TABLE ANIMAL(ANIMAL_ID BIGINT PRIMARY KEY, NICK_NAME VARCHAR(255), WEIGHT DOUBLE, BREED_ID BIGINT, ANIMAL_PLACE VARCHAR(255), PHOTO BLOB, EVENT VARCHAR(255), foreign key (BREED_ID) references breed(BREED_ID));
DROP TABLE IF EXISTS OWNER;
CREATE TABLE OWNER(OWNER_ID BIGINT PRIMARY KEY, NICK_OWNER VARCHAR(255), ANIMAL_ID BIGINT, EMAIL VARCHAR(255), foreign key (ANIMAL_ID) references animal(ANIMAL_ID));