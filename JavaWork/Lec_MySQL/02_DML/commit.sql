SELECT * FROM t_student;


# commit, rollback

SELECT * FROM phonebook;

-- MySQL 은 기본적으로 auto-commit 
DROP TABLE IF EXISTS phonebook;

CREATE TABLE phonebook(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(80) NOT NULL,
	phonenum varchar(20) DEFAULT '010-0000-0000',
	email varchar(100),
	regdate datetime DEFAULT now()
);

INSERT INTO phonebook (id, name, phonenum, email)
	VALUES
		(4,'아이언맨', '111-1111-1111', 'ironman@mail.com'),
		(5, '캡틴아메리카', '222-2222-2222', 'captain@mail.com'),
		(6, '토르', '3333-3333-3333', 'thor@mail.com')
		;

	
SELECT * FROM phonebook;

DELETE FROM phonebook ;  -- WHERE 절이 없으면 DELETE 는 모든 row를 지운다

-- transaction 을 수행하기 위해서 
-- auto commit 부터 비활성화 해야 한다. 

SELECT @@autocommit;    -- 현재 auto COMMIT 활성화 여부 1: 활성화  0:비활성화

SET autocommit=0;	-- auto COMMIT 비활성화

DELETE FROM phonebook WHERE id =5;

SELECT * FROM phonebook;

-- ROLLBACK 하기전 마지막으로 commit 한 지점까지 복구
ROLLBACK;

UPDATE phonebook SET name = 'IRON MAN' WHERE id=1;

COMMIT;

DELETE FROM phonebook WHERE id = 2;

SELECT * FROM phonebook;

ROLLBACK;

SET autocommit =1; -- auto COMMIT 활성화

