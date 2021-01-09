CREATE DATABASE web_day7;

USE web_day7;


CREATE TABLE STUDENT(
	ID BIGINT NOT NULL AUTO_INCREMENT,
	IDENTITY_NUMBER VARCHAR(20) NOT NULL,
    NAME VARCHAR(50) NOT NULL, 
    DOB DATE,
    GENDER VARCHAR(6),
    PRIMARY KEY ( ID )
);

SELECT * FROM STUDENT;
create table book(
	id int not null auto_increment,
    name varchar(300) not null,
    author varchar(200),
    release_year int unsigned,
    number_of_pages int unsigned,
    price double,
    primary key(id)
);
select *from book;


