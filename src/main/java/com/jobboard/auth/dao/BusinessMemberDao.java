package com.jobboard.auth.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jobboard.auth.model.BusinessMember;
import com.jobboard.web.dao.MybatisSessionFactory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusinessMemberDao {
	private static BusinessMemberDao instance;
	
	public static BusinessMemberDao getInstance() {
		if(instance == null) {
			instance = new BusinessMemberDao();
		}
		return instance;
	}
	
	private final String NAMESPACE = "BusinessMemberMapper";
	private final SqlSessionFactory sqlSessionFactory = MybatisSessionFactory.getInstance();
	
	public int signUp(BusinessMember businessMember) {
        SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.insert(NAMESPACE + ".signUp", businessMember);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			sqlSession.close();
		}
        return -1;
    }
	
	public int checkUsernameDuplicate(String username) {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			return sqlSession.selectOne(NAMESPACE + ".countByUsername", username);
		}
	}
}
