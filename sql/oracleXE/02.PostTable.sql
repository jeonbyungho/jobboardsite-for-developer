-- 채용 공고 게시판
drop table recruitment_bulletin;

CREATE TABLE recruitment_bulletin (
		recrui_id NUMBER PRIMARY KEY
	--,	empl_id NUMBER,
	,	title varchar(100) NOT NULL
	,	content varchar(2000) NOT NULL
	,	photo_path varchar(400)
	,	created_at DATE DEFAULT sysdate
	,	modified_at DATE
	--,	FOREIGN KEY (empl_id) REFERENCES Employer(empl_id) ON DELETE CASCADE
);

COMMENT ON TABLE recruitment_bulletin IS '채용 공고 게시판';

CREATE SEQUENCE recruitbull_seq
	START WITH 1
	INCREMENT BY 1;
	
insert into RECRUITMENT_BULLETIN rb (
		rb.recrui_id
	,	rb.title
	,	rb.content
	,	rb.photo_path
) values (
		recruitbull_seq.nextval
	,	'title'
	,	'content'
	,	'photo_path/'
);