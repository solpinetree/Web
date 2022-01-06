SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS exam_coupon;




/* Create Tables */

CREATE TABLE exam_coupon
(
	cp_uid int NOT NULL AUTO_INCREMENT,
	cp_name varchar(15) NOT NULL,
	cp_kind varchar(5) NOT NULL,
	cp_sno char(10),
	PRIMARY KEY (cp_uid),
	UNIQUE (cp_sno)
);

INSERT INTO exam_coupon
	(cp_name, cp_kind, cp_sno)
	VALUES
('asgddgs', '정기권', '12aa-b1-77');

SELECT * FROM exam_coupon;