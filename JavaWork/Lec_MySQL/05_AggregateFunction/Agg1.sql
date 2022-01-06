SELECT count(*), count(HPAGE) FROM t_professor; 
-- > 그룹 함수에서는 NULL 값은 (기본적으로) 계산에서 배제

SELECT * FROM t_professor;

SELECT sum(pay), count(PAY), avg(PAY) from t_professor;
SELECT sum(bonus), count(bonus), avg(ifnull(bonus,0)) from t_professor;

-- GROUP BY

-- t_professor 테이블에서 '학과별'로 교수들의 평균 보너스를 출력하세요
SELECT deptno, avg(ifnull(bonus,0))
FROM t_professor GROUP BY deptno
;
-- >SELECT 절에 그룹함수 아닌 것과 그룹함수는 같이 올수는 없다. 
-- 이 경우 그룹함수가 아닌 것들은 GROUP BY 로 묶여야 할 것이다.


-- HAVING : 그룹 함수에 조건 추가
-- 학과별 평균급여를 출력하되, 평균급여가 450 보다 많은 학과만 출력
SELECT deptno, avg(ifnull(pay,0))
FROM t_professor 
GROUP BY deptno
HAVING avg(ifnull(pay,0)) > 450
;

-- <SELECT 쿼리문 순서>  -   처리순서
-- 	SELECT             - (5)
-- 	FROM               - (1)
-- 	WHERE              - (2)
-- 	GROUP BY           - (3)
-- 	HAVING             - (4)
--  ORDER BY           - (6)



