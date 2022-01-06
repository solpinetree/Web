-- t_student 테이블: 1학년 학생의 이름과 생일과 키와 몸무게를 출력하세요, 
-- 단 생일이 빠른 사람 순서대로 정렬하세요.
SELECT name, birthday, height, weight FROM t_student 
WHERE grade=1 ORDER BY birthday
;

-- 11.  t_student 테이블: 1학년 학생의 이름과 키를 출력하세요, 별명은 ‘이름’, ‘키’ 로 출력. 
-- 단, 이름은 오름차순으로 정렬하세요
SELECT name 이름, height 키 FROM t_student 
WHERE grade =1 ORDER BY name
;

-- 12.  t_emp2 직원 테이블에서 생일(birthday) 이 1980년대생인 사람들의 이름과 생일만 출력하세요 
-- 즉 (1980/01/01 ~ 1989/12/31 사이 출생한 직원들)
SELECT name, birthday FROM t_emp2 
WHERE birthday LIKE '198%'
;