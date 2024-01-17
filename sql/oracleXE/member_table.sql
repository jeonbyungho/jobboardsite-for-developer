
-- 회원
CREATE TABLE members (
	mb_id NUMBER(20) PRIMARY KEY,
	username varchar(255) UNIQUE NOT NULL,
	password varchar(255) NOT NULL,
	email varchar(255),
	created_at DATE DEFAULT sysdate
);

COMMENT ON TABLE members IS '가입한 회원';

CREATE SEQUENCE member_seq
	START WITH 1
	INCREMENT BY 1;

-- 고용 회원
CREATE TABLE employer (
	empl_id NUMBER(20) PRIMARY KEY,
	mb_id NUMBER(20),
	business_registration_number varchar(255) NOT NULL,
	company_name varchar(255) NOT NULL,
	founding_date DATE,
	FOREIGN KEY (mb_id) REFERENCES members(mb_id) ON DELETE CASCADE
);

COMMENT ON TABLE employer IS '고용주';

CREATE SEQUENCE employer_seq
	START WITH 1
	INCREMENT BY 1;