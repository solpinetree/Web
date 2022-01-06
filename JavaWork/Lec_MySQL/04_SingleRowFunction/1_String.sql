SELECT 'Hello', length('Hello')
;

SELECT ename, length(ename), lower(ename)
FROM t_emp;

-- t_student 테이블 : 
-- ID가 9글자 이상인 학생들의 
-- 이름과 ID 와 글자수 출력 / length() 사용
SELECT name, id, length(id) 글자수
FROM t_student WHERE length(id) >= 9
;

#---------------------------------------------
#-- SUBSTR 함수 
#-- 구문: SUBSTR( ‘문자열’ 또는 컬럼명,   시작위치,  추출할 글자수 )
#-- 문자열에서 특정 길이의 문자를 추출할 때 사용하는 함수
#-- 시작위치, 음수 가능.
#-- ★ 시작 인덱스가 1부터 시작한다 (인덱스는 1부터 시작) 

SELECT substr('ABCDE', 2, 1);

SELECT name, substr(jumin, 1,6) 생년월일
FROM t_student WHERE deptno1=101
;

#-------------------------------------------------
# INSTR()
# 주어진 문자열이나 컬럼에서 특정 글자의 위치를 찾아주는 함수 (인덱스 리턴)

SELECT instr('ABCDEFG', 'DE');    --  못찾으면 0 리턴

SELECT name, tel, instr(tel, ')')  ') 위치'
FROM t_student;

SELECT name, tel, substr(tel, 1, instr(tel, ')')-1)  
FROM t_student;