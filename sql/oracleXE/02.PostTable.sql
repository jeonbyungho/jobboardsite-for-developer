-- 채용 공고 게시판
CREATE TABLE recruitment_bulletin (
	recrui_id NUMBER PRIMARY KEY,
	empl_id NUMBER,
	title varchar(100) NOT NULL,
	content varchar(2000) NOT NULL,
	created_date DATE DEFAULT sysdate,
	modified_date DATE,
	FOREIGN KEY (empl_id) REFERENCES Employer(empl_id) ON DELETE CASCADE
);

COMMENT ON TABLE recruitment_bulletin IS '채용 공고 게시판';

CREATE SEQUENCE recruitbull_seq
	START WITH 1
	INCREMENT BY 1;

CREATE TABLE recruitment_bulletin_images (
	recrui_id NUMBER PRIMARY KEY,
	img_path varchar(1000) NOT NULL,
	FOREIGN KEY (recrui_id) REFERENCES recruitment_bulletin(recrui_id) ON DELETE CASCADE
);