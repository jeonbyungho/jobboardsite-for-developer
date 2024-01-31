-- Oracle Database 18c Express Edition Release 18.0.0.0.0 - Production
-- 오라클 DB 12C 버전부터 유저명에 c##을 붙이지 않을 경우 다음과 같은 오류가 발생합니다.
-- ORA-65096: invalid common user or role name
-- "_ORACLE_SCRIPT" 세션을 true로 변경하면 c##를 붙이지 않고도 유저를 생성할 수 있게 됩니다.
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

-- JOBBOARD 유저를 생성합니다.
CREATE USER JOBBOARD IDENTIFIED BY 1234;

-- JOBBOARD 유저의 권한을 부여합니다.
GRANT CONNECT, RESOURCE TO jobboard;

-- 방금 생성한 유저를 조회합니다.
SELECT
    user_id,
    username
FROM
    sys.all_users
WHERE
    username = 'JOBBOARD';

SELECT
    *
FROM
    dba_role_privs
WHERE
    grantee = 'JOBBOARD';

-- 오라클 계정 삭제
DROP USER jobboard CASCADE;