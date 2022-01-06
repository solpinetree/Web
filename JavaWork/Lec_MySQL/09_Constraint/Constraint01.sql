-- 제약 조건(Constraint)

-- t_dept2 참조할 예정
SELECT * FROM t_dept2;

-- MySQL 에서 Table의 제약조건들 확인
SELECT * FROM information_schema.TABLE_CONSTRAINTS 
WHERE TABLE_SCHEMA = 'mydb811';

SELECT * FROM information_schema.TABLE_CONSTRAINTS 
WHERE TABLE_SCHEMA = 'mydb811' AND table_name='t_emp4';

-- #9001
-- 제약조건명을 명시하지 않고 정의
DROP TABLE IF EXISTS t_emp4 CASCADE;
CREATE TABLE t_emp4(
	NO int(4) PRIMARY KEY,
	name varchar(10) NOT NULL,
	jumin varchar(13) NOT NULL unique,
	area int(1) CHECK(area < 5),
	deptno varchar(6) REFERENCES t_dept2(Dcode)
);

DESC t_emp4;


-- 별도의 항목으로 정의 가능
DROP TABLE IF EXISTS t_emp4 CASCADE;
CREATE TABLE t_emp4(
	NO int(4),
	name varchar(10) NOT null,
	jumin varchar(13) NOT null,
	area int(1),
	deptno varchar(6),
	PRIMARY key(no),
	unique(jumin),
	check(area < 5),
	FOREIGN KEY (deptno) REFERENCES t_dept2(dcode)
);


-- #9002
-- 제약조건 명을 명시하기
DROP TABLE IF EXISTS t_emp3 CASCADE;
CREATE TABLE t_emp3(
	NO int(4),
	name varchar(10) NOT null,
	jumin varchar(13) NOT null,
	area int(1),
	deptno varchar(6),
	CONSTRAINT emp3_no_pk PRIMARY key(no),
	CONSTRAINT emp3_jumin_uk unique(jumin),
	CONSTRAINT emp3_area_ck check(area < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY (deptno) REFERENCES t_dept2(dcode)
);

-- t_emp4와 t_emp3에 설정된 제약조건들 확인하기
SELECT * FROM information_schema.TABLE_CONSTRAINTS 
WHERE TABLE_SCHEMA = 'mydb811' AND table_name='t_emp4';

SELECT * FROM information_schema.TABLE_CONSTRAINTS 
WHERE TABLE_SCHEMA = 'mydb811' AND table_name='t_emp3';

-- #9005) t_emp3의 제약조건에 맞는 / 위배되는 DML 작성
INSERT INTO t_emp3 values(1, 'MySQL','1234561234567',4,1000);

INSERT INTO t_emp3 values(2, 'MySQL', '1234561234567', 4, 1000);
-- jumin unique 오류

INSERT INTO t_emp3 values(2, 'MySQL', '22222222222222222222', 4, 1000);

INSERT INTO t_emp3 values(2, 'Tiger', '2222222222222', 10, 1000);

INSERT INTO t_emp3 values(3, 'MySQL', '2222222222', 3, 2000);
-- fk : 참조하는 쪽을 child, 참조 받는 쪽을 parent

INSERT INTO t_emp3 (NO, jumin, area, deptno) VALUES(2, '3333333333333', 4, 1001);

-- update / delete 에서도 제약조건 오류 발생 가능

SELECT * FROM t_emp3;

UPDATE t_emp3 SET area =10 WHERE NO=1;

DELETE FROM t_dept2 WHERE dcode = 1000; -- 참조되고 있는 부모는 삭제 불가

# -------------------------------------------------------------------


-- # 9005 ALTER 명령 사용하여 테이블에 제약조건 추가 가능

ALTER table t_emp4 ADD CONSTRAINT emp4_name_uk unique(name);





































