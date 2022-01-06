-- INSERT 의 subquery

CREATE TABLE test_emp_a (
	emp_id int, 
	emp_name varchar(100)	
);

CREATE TABLE test_emp_b (
	emp_id int, 
	emp_name varchar(100)	
);

-- 한개의 row INSERT 
INSERT INTO test_emp_a values(101, '아이언맨');
INSERT INTO test_emp_b values(201, '캡틴아메리카');

SELECT * FROM test_emp_a ;
SELECT * FROM test_emp_b ;

-- 여러개의 row를 한번에 INSERT
INSERT INTO test_emp_a 
values(102, '블랙위도우'), (103, '토르'), (103, '블랙팬서');

-- subquery 로 insert 가능
INSERT INTO test_emp_a (SELECT * FROM test_emp_a);  -- 기존 TABLE x 2배 만들기

INSERT INTO test_emp_a (SELECT 105, '스파이더맨');

INSERT INTO test_emp_b(emp_id) (SELECT emp_id FROM test_emp_a);

SELECT * FROM phonebook;
DESC phonebook; 	-- phonebook의 SCHEMA

INSERT INTO phonebook(name, regdate)
VALUES('프로도', now()),('쌤',now());

INSERT INTO phonebook (SELECT * FROM phonebook); -- 에러, PK 중복
INSERT INTO phonebook (name, regdate)
(SELECT name, now() FROM phonebook);

#-------------------------------------------------------------


-- create table + subquery
CREATE TABLE test_emp_c
AS 
SELECT * FROM test_emp_a;

SELECT * FROM test_emp_c;





