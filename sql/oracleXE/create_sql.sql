--DROP TABLE MEMBER;
--DROP TABLE employer;
--DROP SEQUENCE Member_seq;
--DROP SEQUENCE Employer_seq;

CREATE TABLE MEMBERS (
	member_id NUMBER PRIMARY KEY,
	username varchar(100) UNIQUE NOT NULL,
	password varchar(100) NOT NULL,
	email varchar(100),
	created_date DATE DEFAULT sysdate
);

CREATE TABLE Employer (
	empl_id NUMBER,
	member_id NUMBER,
	name varchar(100) UNIQUE NOT NULL,
	PRIMARY KEY (empl_id),
	FOREIGN KEY (member_id) REFERENCES MEMBERS(member_id) ON DELETE CASCADE
);

CREATE SEQUENCE Member_seq
	START WITH 1
	INCREMENT BY 1;
	
CREATE SEQUENCE Employer_seq
	START WITH 1
	INCREMENT BY 1;
	
-- 회원가입
BEGIN
	INSERT INTO MEMBERS m (
		m.member_id, m.username, m.password, m.email
	) VALUES (
		MEMBER_SEQ.nextval,
		'company_test',
		'1234',
		'test@gmail.com'
	);
	INSERT INTO EMPLOYER e (
		e.empl_id, e.member_id, e.name
	) VALUES (
		EMPLOYER_SEQ.nextval,
		MEMBER_SEQ.currval,
		'유령회사'
	);
END;
