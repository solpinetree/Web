DROP TABLE IF EXISTS test_authority CASCADE;
DROP TABLE IF EXISTS test_member CASCADE;

CREATE TABLE test_member (
    mb_uid INT PRIMARY KEY AUTO_INCREMENT,
    mb_id varchar(50) NOT NULL UNIQUE,   -- 시큐리티의 username
    mb_pw varchar(256) NOT NULL,         -- 시큐리티의 password
    mb_email varchar(120),
    mb_enabled char(1) DEFAULT '1',      -- 시큐리티의 enabled
    mb_regdate datetime DEFAULT now()
);

CREATE TABLE test_authority (
    mb_id varchar(50) REFERENCES test_member(mb_id),
    mb_auth varchar(50) NOT NULL,        -- 시큐리티의 authority
    PRIMARY KEY (mb_id, mb_auth)
);

-- 확인
SELECT m.mb_id, m.mb_pw, a.mb_auth, m.mb_enabled
FROM test_member m LEFT OUTER JOIN test_authority a 
ON m.mb_id = a.mb_id;

SELECT * FROM test_member ORDER BY mb_uid DESC;
SELECT * FROM test_authority;

