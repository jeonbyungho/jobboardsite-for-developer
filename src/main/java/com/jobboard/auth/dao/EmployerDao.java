package com.jobboard.auth.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jobboard.auth.model.Employer;
import com.jobboard.web.dao.MybatisSessionFactory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployerDao implements MemberDao<Employer>{
	private static EmployerDao instance;
	
	public static EmployerDao getInstance() {
		if(instance == null) {
			instance = new EmployerDao();
		}
		return instance;
	}
	
	private final String NAMESPACE = "EmployerMapper";
	private final SqlSessionFactory sqlSessionFactory = MybatisSessionFactory.getInstance();
	
	@Override
	public Optional<Employer> signIn(String username, String password) {
		Employer employer = null;
		Map<String, String> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			employer = sqlSession.selectOne(NAMESPACE + ".signIn", params);
			return Optional.ofNullable(employer);
		}
	}
	
	@Override
	public int signUp(Map<String, Object> params) {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.insert(NAMESPACE + ".signUp", params);
			sqlSession.commit();
			return 1;
		} catch (PersistenceException e) {
			e.printStackTrace();
			sqlSession.rollback();
			sqlSession.close();
		}
		return -1;
	}
	
	@Override
	public int checkUsernameDuplicate(String username) {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			return sqlSession.selectOne(NAMESPACE + ".countByUsername", username);
		}
	}
}
