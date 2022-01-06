DROP TABLE IF EXISTS test_member CASCADE;

CREATE TABLE test_member(
	mb_no int PRIMARY KEY AUTO_INCREMENT, 
	mb_name varchar(40) NOT NULL,
	mb_age int DEFAULT 1,
	mb_regdate datetime DEFAULT now()	
);

INSERT INTO test_member (mb_name)
VALUES ('토르'),('발키리'),('코르그'),('하임달');

SELECT * FROM test_member;

SELECT * FROM test_member ORDER BY mb_no DESC;