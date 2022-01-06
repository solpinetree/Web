-- JOIN

-- FROM 절의 테이블에 별칭(alias)를 줄 수 있다.

-- 학생 20명
SELECT s.studno, s.name, s.deptno1
FROM t_student s
;

-- 학과 12개 
SELECT d.deptno, d.dname 
FROM t_department d
;

-- 교수님 16명
SELECT p.PROFNO, p.name, p.DEPTNO 
FROM t_professor p
;

-- 카디션곱
-- 두개의 테이블을 JOIN 하게 되면, 
-- 각 테이블의 레코드들의 모든 조합이 출력된다. 
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면
-- 모든 카티션곱이 출력된다. 
-- 20 x 12 = 240 개의 row
SELECT s.studno, s.name, s.deptno1, d.deptno, d.dname
FROM t_student s, t_department d
;

-- 위의 카티션 곱에서 조건을 주면 원하는 레코드만 추출 가능.

---------------------------------------------------------------
-- Equi Join(등가 Join)
-- 일반적으로 많이 쓰이는 Join 이며, 양쪽 테이블 Join한 카티션곱에서 '같은조건'이 존재할 경우만 
-- 값을 가져오는 것

-- 예) #6101
-- t_student 테이블과 t_department 테이블을 사용하여 학생이름, 1전공 학과번호, 1전공 학과이름
-- 을 출력하세요

-- MySQL
SELECT s.name, s.deptno1, d.dname 
FROM t_student s, t_department d
WHERE s.deptno1 = d.deptno		-- JOIN 조건 
;

-- ANSI 구문
SELECT s.name "학생이름", s.deptno1, d.dname 
FROM t_student s JOIN t_department d 
		ON  s.deptno1 = d.deptno	-- JOIN 조건
;

-- 연습 #6120)
-- t_student 테이블, t_professor 테이블 을 join하여 
-- ‘학생이름’, ‘지도교수 번호’, ‘지도교수이름’ 을 출력하세요
SELECT s.name "학생이름", s.profno "지도교수 번호", p.NAME "지도교수이름"
FROM t_student s JOIN t_professor p 
		ON s.profno = p.PROFNO 
;

SELECT s.name "학생이름", s.profno "지도교수 번호", p.NAME "지도교수이름"
FROM t_student s, t_professor p 
WHERE s.profno = p.PROFNO 
;

-- null 값은 Join 조건에 참여 안함. 
SELECT name, profno FROM t_student;

-- #6103) 
-- t_student, t_department, t_professor 테이블 을 join 하여  
-- 학생의 이름, 학과이름, 지도교수 이름  을 출력하세요
SELECT s.name "학생이름", d.dname "학과이름", p.NAME "지도교수"
FROM t_student s, t_department d, t_professor p
WHERE s.deptno1 = d.deptno AND s.profno = p.PROFNO;

SELECT s.name "학생이름", d.dname "학과이름", p.NAME "지도교수"
FROM t_student s join t_department d ON s.deptno1 = d.deptno
		join t_professor p ON s.profno = p.PROFNO
;

