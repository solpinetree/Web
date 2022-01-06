SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS NEW_TABLE;
DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS prof;
DROP TABLE IF EXISTS stud;
DROP TABLE IF EXISTS dept;




/* Create Tables */

CREATE TABLE dept
(
	deptno int NOT NULL,
	phonenum varchar(20) NOT NULL,
	office varchar(30) NOT NULL,
	name varchar(10) NOT NULL,
	PRIMARY KEY (deptno)
);


CREATE TABLE NEW_TABLE
(
	studno int NOT NULL,
	subno int NOT NULL
);


CREATE TABLE prof
(
	profno varchar(8) NOT NULL,
	jumin varchar(13) NOT NULL,
	addr varchar(30),
	hireyear varchar(4),
	phonenum varchar(20),
	pos varchar(8),
	name varchar(5) NOT NULL,
	deptno int NOT NULL,
	PRIMARY KEY (profno)
);


CREATE TABLE stud
(
	studno int NOT NULL,
	jumin varchar(13) NOT NULL,
	name varchar(5) NOT NULL,
	grade int,
	phonenum varchar(20),
	addr varchar(30),
	deptno int NOT NULL,
	PRIMARY KEY (studno)
);


CREATE TABLE subject
(
	subno int NOT NULL,
	subunit double NOT NULL,
	subname varchar(10) NOT NULL,
	studno int,
	subclass varchar(10) NOT NULL,
	subyear varchar(4),
	profno varchar(8) NOT NULL,
	PRIMARY KEY (subno)
);



/* Create Foreign Keys */

ALTER TABLE prof
	ADD FOREIGN KEY (deptno)
	REFERENCES dept (deptno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE stud
	ADD FOREIGN KEY (deptno)
	REFERENCES dept (deptno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE subject
	ADD FOREIGN KEY (profno)
	REFERENCES prof (profno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE NEW_TABLE
	ADD FOREIGN KEY (studno)
	REFERENCES stud (studno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE NEW_TABLE
	ADD FOREIGN KEY (subno)
	REFERENCES subject (subno)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



