SELECT * FROM t_emp;

-- scott 의 급여
SELECT sal FROM t_emp WHERE ename='SCOTT'
;

SELECT ename, sal FROM t_emp 
WHERE sal > (SELECT sal FROM t_emp WHERE ename='SCOTT')
;

-- #7102) t_student 테이블에서 가장 키 큰 학생의 '이름'과 '키'를 출력
SELECT max(height) FROM t_student;

SELECT name, height FROM t_student 
WHERE height = (SELECT max(height) FROM t_student)
;

-- 1. 단일행 쿼리
-- subQuery 결과가 한개 1행만 나오는 것. 
-- 단일행 Sub Query 의 WHERE 에서 사용되는 연산자 
-- =, <>, >, >=, <, <-

-- #7103) t_student, t_department 테이블 사용하여 이윤나 학생과 1전공이 동일한 학생들의 이름과 1전공 이름을 출력하세요
SELECT s.name "학생이름", d.dname "1전공"
FROM t_student s, t_department d
WHERE s.deptno1 = d.deptno 
	AND s.deptno1 = (SELECT deptno1 FROM t_student WHERE name='이윤나')
;

-- #7105) t_student 테이블 : 1전공이 101번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의 이름과 몸무게를 출력하세요
SELECT avg(weight) FROM t_student WHERE deptno1 = '101'

SELECT name, weight 
FROM t_student 
WHERE weight > (SELECT avg(weight) FROM t_student WHERE deptno1 ='101')
;

-- #7106) t_professor 테이블에서 심슨 교수와 같은 입사일에 입사한 교수 중, 조인형 교수보다 월급을 적게 받는 교수의 이름과 급여, 입사일을 출력하세요
SELECT name, pay, HIREDATE 
FROM t_professor 
WHERE pay < (SELECT pay FROM t_professor WHERE name='조인형')
	AND HIREDATE = (SELECT HIREDATE FROM t_professor WHERE name='심슨')
;

-- 2. 다중행 쿼리 
-- Sub Query 결과가 2건 이상 출력되는 것을 말합니다.
-- 다중행 Sub Query 와 함께 사용하는 연산자
-- 		IN 같은 값을 찾음
-- 		>ANY 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 큰)
-- 		<ANY 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 작은)
-- 		<ALL 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 작은)
-- 		>ALL 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 큰)
-- 		EXIST Sub Qudery 값이 있을 경우 반환


-- #7107) 
-- t_emp2, t_dept2 테이블 : 근무지역 (t_dept2.area) 이 서울 지사인 모든 사원들의 사번(empno)과 이름(name), 부서번호(deptno)를 출력하세요

-- 근무지역이 서울지사인 부서들
SELECT dcode FROM t_dept2 WHERE area ='서울지사';

SELECT e.EMPNO, e.NAME, e.DEPTNO 
FROM t_emp2 e
WHERE deptno IN (SELECT dcode FROM t_dept2 WHERE area='서울지사')
;

-- #7108) 
-- t_emp2 테이블 : 전체직원중 과장 직급의 최소연봉자보다 연봉이 높은 사람의 이름(name)과 직급(post), 연봉(pay)을 출력하세요.
-- 단, 연봉 출력 형식은 천 단위 구분 기호와 원 표시를 하세요

SELECT pay FROM t_emp2 WHERE post='과장';

SELECT name "이름", post "직급", pay "연봉"
FROM t_emp2
WHERE pay > any(SELECT pay FROM t_emp2 WHERE post='과장')
;

-- #7109)
-- t_student 테이블 : 전체학생중에서 체중이 4학년 학생들의 체중에서 가장 적게 나가는 학생보다 몸무게가 적은 학생의 이름과 학년과 몸무게를 출력하세요
SELECT name, grade, weight 
FROM t_student
WHERE weight < all(SELECT weight FROM t_student WHERE grade='4')
;


-- #7110)  
-- t_emp2, t_dept2 테이블 : 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다 
-- 적게 받는 직원들의 부서명, 직원명, 연봉을 출력 하세요
SELECT d.DNAME "부서명", e.NAME "직원명", e.PAY "연봉"
FROM t_emp2 e, t_dept2 d
WHERE e.pay <all(SELECT avg(pay) FROM t_emp2 GROUP BY DEPTNO)
	AND d.dcode = e.DEPTNO 
ORDER BY 연봉
;













