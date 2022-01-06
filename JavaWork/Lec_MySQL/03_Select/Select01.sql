SELECT 100;

SELECT 100, '안녕하세요', now();

SELECT * FROM t_emp;

-- 컬럼 별칭(alias)
SELECT studno 학번, name 이름
FROM t_student;

SELECT studno "학생 학번", name AS "학생 이름"
FROM t_student;

#-- DISTINCT - 중복값 제거하고 출력
#-- SELECT  DISTINCT [컬럼명 또는 표현식] FROM [테이블명, 뷰명] ;
SELECT name, deptno1
FROM t_student;

SELECT DISTINCT deptno1
FROM t_student;

SELECT *
FROM t_emp;

-- 산술연산
SELECT ename, sal, sal*1.1 "급여인상분"
FROM t_emp;


-- WHERE : 원하는 조건만 검색

-- SELECT [컬럼명 또는 표현식] 
-- FROM [테이블명, 뷰명]  
-- WHERE [조건절] ;

-- 직원 테이블(t_emp) 에서 직책(job) 이 salesman 인 사람만 조회 
SELECT * FROM t_emp WHERE job='salesman';
SELECT * FROM t_emp WHERE job='SALESMAN';  -- MySQL은 문자열 데이터도 대소문자 구분 없이 비교(디폴)
SELECT * FROM t_emp WHERE BINARY(job)='salesman'; -- MySAL 에서 대소문자 구분하여 비교


#--직원 테이블(t_emp) 에서 급여(sal) 가 2000보다 큰 사람의 
#--이름(ename)과 급여(sal)를 출력하세요
SELECT ename, sal FROM t_emp WHERE sal>2000;

-- 학생 테이블(t_student) 에서
-- 2,3 학년(grade) 학생의  이름(name), 학년(grade) 출력
SELECT name, grade FROM t_student WHERE grade=2 OR grade=3;
SELECT name, grade FROM t_student WHERE grade IN (2,3);

SELECT name, grade FROM t_student 
WHERE grade BETWEEN 2 AND 3;

-- 교수님 (t_professor) 중에서
-- 급여 (pay) 가 300 보다 크고,
-- 직급 (position) 이 '정교수' 인 분들의
-- 이름(name), 급여(pay), 직급(position) 을 출력하세요
SELECT name, pay, `POSITION` FROM t_professor 
WHERE pay>300 AND `POSITION` ='정교수';

-- 보너스(bonus)를 못받고 있는 
-- 교수님의 이름(name)과 직급(position)를 출력하세요
SELECT name, POSITION FROM t_professor 
where bonus IS NULL;

-- 교수님의 이름, 급여, 보너스, 급여 + 보너스
-- 주의!) null 값과 다른 값과의 연산결과는 null 이다!!
SELECT name, pay, bonus, pay+bonus
FROM t_professor
WHERE ;

-- LIKE 와 같이 쓰는 와일드 카드  % ,  _
-- % : 글자수 제한 없고 어떤 글자가 와도 됨
-- _ : 글자수는 한글자가 반드시 와야 되고 어떤 글자 와도 좋음

--  교수님 중에서 김씨 성을 가진 교수님의 이름만 출력 (LIKE 사용)
SELECT name FROM t_professor 
WHERE name LIKE '김%';

-- 연습
-- 직원 테이블(t_emp)에서 직원이름 (ename) 중에
-- 두번째 글자가 'A' 인 사람의 이름(ename)만 출력
SELECT ename FROM t_emp 
WHERE ename LIKE '_A%';

SELECT * FROM t_student;
-- 여학생만 select 해보세요!
SELECT * FROM t_student
WHERE jumin LIKE '______2%';


-- ORDER BY

-- 직원중 이름에 L 이 들어간 사람의 이름을  샐러리(sal)오름차순으로 출력하기
SELECT * FROM t_emp 
WHERE ename LIKE '%L%'
ORDER BY sal;

SELECT * FROM t_emp 
WHERE ename LIKE '%L%'
ORDER BY sal desc;


-- 직원의 이름,직책, 급여를 출력하되
-- 우선은 직책(job) 사전 내림차순으로, 
-- 그리고 급여(sal) 오름차순으로 출력
SELECT ename, job, sal FROM t_emp 
ORDER BY job DESC, sal asc
;

