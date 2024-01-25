package com.jobboard.auth.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jobboard.auth.domain.Employer;
import com.jobboard.web.mybatis.MybatisSessionFactory;

public class EmployerDao implements AuthenticationDao<Employer>{
	private static EmployerDao instance;
	
	private EmployerDao() {}
	
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
		Map<String, String> parameter = new HashMap<>();
		parameter.put("username", username);
		parameter.put("password", password);
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			Employer employer = sqlSession.selectOne(NAMESPACE + ".signIn", parameter);
			return Optional.ofNullable(employer);
		}
	}
	
	@Override
	public int signUp(Map<String, Object> parameters) {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.insert(NAMESPACE + ".signUp", parameters);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			sqlSession.close();
		}
		return -1;
	}
	
	@Override
	public int duplicateUsername(String username) {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			return sqlSession.selectOne(NAMESPACE + ".countByUsername", username);
		}
	}
}
