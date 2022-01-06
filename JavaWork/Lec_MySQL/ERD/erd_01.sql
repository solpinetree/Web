SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS register;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS professor;




/* Create Tables */

CREATE TABLE professor
(
	profno int NOT NULL AUTO_INCREMENT,
	name varchar(10) NOT NULL,
	deptno int,
	PRIMARY KEY (profno)
);


CREATE TABLE register
(
	studno int NOT NULL,
	subjno int NOT NULL
);


CREATE TABLE student
(
	studno int NOT NULL AUTO_INCREMENT,
	name varchar(10) NOT NULL,
	deptno int,
	profno int NOT NULL,
	PRIMARY KEY (studno)
);


CREATE TABLE subject
(
	subjno int NOT NULL AUTO_INCREMENT,
	name varchar(10) NOT NULL,
	profno int NOT NULL,
	PRIMARY KEY (subjno)
);



/* Create Foreign Keys */

ALTER TABLE student
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE subject
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE register
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE register
	ADD FOREIGN KEY (subjno)
	REFERENCES subject (subjno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



