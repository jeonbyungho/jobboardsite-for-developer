CREATE TABLE member (
    id NUMBER(20, 0) PRIMARY KEY,
    username VARCHAR2(255) UNIQUE NOT NULL,
    password VARCHAR2(255) NOT NULL,
    email VARCHAR(255),
    created_at DATE DEFAULT sysdate
);

CREATE SEQUENCE member_seq START WITH 1 INCREMENT BY 1;

COMMENT ON TABLE member IS '회원';

CREATE TABLE individual_member (
    member_id NUMBER(20, 0),
    name VARCHAR2(255) NOT NULL,
    phone VARCHAR2(255) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);

COMMENT ON TABLE individual_member IS '개인 회원';

CREATE TABLE business_member (
    member_id NUMBER(20, 0),
    business_registration_number NUMBER(12, 0) NOT NULL,
    company_type NUMBER(1, 0) NOT NULL,
    company_name VARCHAR2(255) NOT NULL,
    ceo_name VARCHAR2(255) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);

COMMENT ON TABLE business_member IS '기업 회원';

-- 회원 가입
SELECT
    member_seq.nextval
FROM
    dual;

BEGIN
    INSERT INTO member (
        id,
        username,
        password,
        email
    ) VALUES (
        member_seq.nextval,
        'test',
        '1234',
        'email@test.com'
    );
    INSERT INTO business_member (
        member_id,
        business_registration_number,
        company_type,
        company_name,
        ceo_name
    ) VALUES (
        member_seq.currval,
        
    );
END;

-- 로그인
SELECT
    m.id,
    m.username,
    m.password,
    m.email,
    m.created_at,
    biz.business_registration_number,
    biz.company_name,
    biz.ceo_name
FROM
    business_member biz
    INNER JOIN member m
    ON biz.member_id = m.id;
