-- 채용 게시판
CREATE TABLE recruitment_bulletin (
	recrui_id NUMBER PRIMARY KEY,
	empl_id NUMBER,
	recrui_title varchar(100) NOT NULL,
	recrui_content varchar(2000) NOT NULL,
	created_date DATE DEFAULT sysdate,
	modified_date DATE,
	FOREIGN KEY (empl_id) REFERENCES Employer(empl_id) ON DELETE CASCADE
);

COMMENT ON TABLE RECRUITMENT_BULLETIN IS '채용 게시판';

CREATE SEQUENCE recruit_bull_seq
	START WITH 1
	INCREMENT BY 1;