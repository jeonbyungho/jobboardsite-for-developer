CREATE TABLE member (
    id NUMBER(20) PRIMARY KEY,
    username VARCHAR2(255) UNIQUE NOT NULL,
    password VARCHAR2(255) NOT NULL,
    email VARCHAR(255),
    created_at DATE DEFAULT sysdate
);

CREATE SEQUENCE member_seq START WITH 1 INCREMENT BY 1;

COMMENT ON TABLE member IS '회원';

CREATE TABLE individual_member (
    member_id NUMBER(20),
    name VARCHAR2(255) NOT NULL,
    phone VARCHAR2(255) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);

COMMENT ON TABLE individual_member IS '개인 회원';

CREATE TABLE business_member (
    member_id NUMBER(20),
    business_registration_number NUMBER(20) NOT NULL,
    company_type NUMBER(1) NOT NULL,
    company_name VARCHAR2(255) NOT NULL,
    ceo_name VARCHAR2(255) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);

COMMENT ON TABLE business_member IS '기업 회원';

