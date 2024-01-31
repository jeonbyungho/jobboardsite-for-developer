-- 회원
CREATE TABLE members (
	mb_id NUMBER(20) PRIMARY KEY,
	username VARCHAR(255) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(255),
	created_at DATE DEFAULT sysdate
);

COMMENT ON TABLE members IS '가입한 회원';

CREATE SEQUENCE members_seq
 START WITH 1
 INCREMENT BY 1;

-- 고용 회원
CREATE TABLE employer (
	empl_id NUMBER(20) PRIMARY KEY,
	mb_id NUMBER(20),
	business_number VARCHAR(255) NOT NULL,
	company_name VARCHAR(255) NOT NULL,
	founding_date DATE,
	FOREIGN KEY (mb_id) REFERENCES members(mb_id) ON DELETE CASCADE
);

COMMENT ON TABLE employer IS '고용주';

CREATE SEQUENCE employer_seq
 START WITH 1
 INCREMENT BY 1;