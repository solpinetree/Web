-- 비등가 조인(Non-Equi Join)

SELECT * FROM t_customer ;
SELECT * FROM t_gift ;

-- #6201)
-- t_customer 테이블, t_gift 테이블을 join 하여
-- 고객의 마일리지 포인트별로 받을수 있는 상품을 조회하여 
-- 고객의 '이름(c_name)'과 포인트(c_point) 상품명(g_name)을 출력하세요
-- BETWEEN ~ AND 사용

SELECT c.c_name "이름", c.c_point "포인트", g.g_name "상품명"
FROM t_customer c, t_gift g
WHERE c.c_point BETWEEN g.g_start AND g.g_end
;

SELECT c.c_name "이름", c.c_point "포인트", g.g_name "상품명"
FROM t_customer c join t_gift g ON c.c_point BETWEEN g.g_start AND g.g_end;

-- #6202) 앞 예제에서 조회한 상품의 
-- 이름(g_name)과  필요수량이 몇개인지 조회하세요
-- 그룹함수 동원
SELECT g.g_name "상품명", count(g.g_name) "필요수량"
FROM t_customer c join t_gift g ON c.c_point BETWEEN g.g_start AND g.g_end 
GROUP BY g.g_name;

-- #6203)  t_student 테이블과 t_exam01 시험성적 테이블, t_credit 학점 테이블을 조회하여  학생들의 이름과 점수와 학점을 출력하세요
SELECT s.name, e.total, c.grade
FROM t_student s, t_exam01 e, t_credit c
WHERE s.studno = e.studno AND e.total BETWEEN c.min_point AND c.max_point 
ORDER BY c.grade
;

-- ANSI 구문
SELECT s.name, e.total, c.grade
FROM t_student s 
	join t_exam01 e ON s.studno = e.studno 
	JOIN t_credit c ON e.total BETWEEN c.min_point AND c.max_point 
ORDER BY c.grade
;

SELECT * FROM t_emp2;
UPDATE t_emp2 SET post = NULL WHERE post=' ';

SELECT * FROM t_post;


SELECT now(), year(now()), month(now()), DAY(now())
;

-- #6205) t_emp2, t_post 테이블 사용하여
-- 사원들의 이름(name)과 나이, 현재직급(post),  ‘예상직급’을 출력하세요. 
-- ‘예상직급’은 나이로 계산하며 해당 나이가 받아야 하는 직급을 의미합니다. 
-- 나이는 오늘(now())을 기준으로 하되 소수점 이하는 절삭하여 계산하세요
SELECT e.NAME "이름", YEAR(now())-YEAR(e.BIRTHDAY)+1 "나이", ifnull(e.POST, '') "현재직급", p.post "예상직급"
FROM t_emp2 e, t_post p
WHERE YEAR(now())-YEAR(e.BIRTHDAY)+1 BETWEEN p.s_age AND p.e_age 
;


-- 지금까지의 JOIN은 모두 INNER JOIN 이다. (default join - inner 키워드 생략 가능)

SELECT s.name, p.name
FROM t_student s INNER JOIN t_professor p ON s.profno = p.PROFNO
;

-- 카티션 곱, 전체를 select 하는 것을 cross join 이라 함.
SELECT s.name, p.name
FROM t_student s, t_professor p
;
-- 카티션 곱 ANSI 버전
SELECT s.name, p.name
FROM t_student s cross JOIN t_professor p
;


----------------------------------------------------------------------------
-- OUTER Join  이란 한쪽 테이블에 데이터가 있고 한쪽테이블에 없는 경우 데이터가 있는 쪽 테이블의 내용을 전부 출력
-- 필연적으로 OUTER Join 은 DB 성능에 나쁜 영향 줌.

-- #6206)
-- t_student 테이블과 t_professor 테이블 Join 하여 학생이름과 지도교수 이름을 출력하세요. 
-- 단! 지도교수가 결정되지 않은 학생의 명단도 함께 출력하세요 
-- 왼쪽 여집합
SELECT s.name, p.name
FROM t_student s LEFT OUTER JOIN t_professor p ON s.profno = p.PROFNO
;

-- #6207)
-- t_student, t_professor 테이블 join :  학생이름과 지도교수 이름을 출력, 
-- 단! 지도 학생이 결정되지 않은 교수 명단도 출력
-- 오른쪽 여집합
SELECT s.name, p.name
FROM t_student s RIGHT OUTER JOIN t_professor p ON s.profno = p.PROFNO
;

-- #6208) t_student, t_professor 테이블 join :  
-- 학생이름과 지도교수 이름을 출력, 
-- 단! 지도 학생이 결정되지 않은 교수 명단, 지도교수가 결정되지 않은 학생명단 모두 출력
-- 합집합

-- MySQL 은 FULL OUTER JOIN 지원암함. 대신! UNION 사용하여 FULL OUTER JOIN 구현
SELECT s.name, p.name
FROM t_student s left OUTER JOIN t_professor p ON s.profno = p.PROFNO
union
SELECT s.name, p.name
FROM t_student s right OUTER JOIN t_professor p ON s.profno = p.PROFNO
;

-- self join
-- 만약 원하는 데이터가 하나의 테이블에 다 들어 있다면?
-- 이럴때 사용하는 것이 SELF Join
SELECT * FROM t_dept2 
;

-- #6209)
-- t_dept2 테이블에서 부서명 과 그 부서의 상위부서명을 출력하세요
SELECT d1.dname 부서명, d2.dname 상위부서명
FROM t_dept2 d1, t_dept2 d2
WHERE d1.pdept = d2.dcode
;

-- #6210) 
-- t_professor 테이블 : 교수번호, 교수이름, 입사일, 그리고 자신보다 입사일 빠른 사람의 인원수를 출력하세요,
-- 단 자신보다 입사일이 빠른 사람수를 오름차순으로 출력하세요

-- 우선! 자신보다 빠른 사람들의 입사일을 select 해보자
SELECT p1.PROFNO "교수번호", p1.name "교수이름", p1.HIREDATE "입사일", p2.name "빠른교수명", p2.HIREDATE "빠른입사일"
FROM t_professor p1 LEFT OUTER JOIN t_professor p2 ON p2.HIREDATE < p1.HIREDATE 
ORDER BY 교수이름
;


SELECT p1.PROFNO "교수번호", p1.name "교수이름", p1.HIREDATE "입사일", count(p2.hiredate) "빠른사람"
FROM t_professor p1 LEFT OUTER JOIN t_professor p2 ON p2.HIREDATE < p1.HIREDATE 
GROUP BY p1.profno, p1.name, p1.HIREDATE 
ORDER BY 4
;

