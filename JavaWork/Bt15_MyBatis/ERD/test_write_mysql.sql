SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS test_write;




/* Create Tables */

CREATE TABLE test_write
(
	wr_uid int NOT NULL AUTO_INCREMENT,
	wr_subject varchar(200) NOT NULL,
	wr_content text,
	wr_name varchar(20) NOT NULL,
	wr_viewcnt int DEFAULT 0,
	wr_regdate datetime DEFAULT now(),
	PRIMARY KEY (wr_uid)
);



SELECT wr_uid uid, wr_subject subject, wr_content content,
	wr_name name, wr_viewcnt viewcnt, wr_regdate regdate
FROM test_write ORDER BY wr_uid desc;

INSERT INTO test_write
	(wr_subject, wr_content, wr_name)
VALUES
	('첫째글:방가요', '안녕하세요', '김희철'),
	('둘째글:헤헤헤','1111', '김수길'),
	('세째글:힘내세요', '7394', '최진덕'),
	('네째글: ... ', '9090', '이혜원'),
	('다섯째글: 게시판', '7531', '박수찬')
;


DELETE FROM test_write WHERE wr_uid >= 10;



		SELECT
			wr_uid uid,
			wr_subject subject,
			wr_content content,
			wr_name name,
			wr_viewcnt viewcnt,
			wr_regdate regDate
		FROM
			test_write
		ORDER BY
			wr_uid DESC;