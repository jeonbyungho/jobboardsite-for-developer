package com.jobboard.auth.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.jobboard.auth.domain.Employer;
import com.jobboard.web.mybatis.MybatisSessionFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployerDao implements AuthenticationDao<Employer>{
	private static EmployerDao instance;
	private final static String NAMESPACE = "EmployerMapper";
	
	private EmployerDao() {}
	
	public static EmployerDao getInstance() {
		if(instance == null) {
			instance = new EmployerDao();
		}
		return instance;
	}
	
	@Override
	public Optional<Employer> signIn(String username, String password) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("username", username);
		parameter.put("password", password);
		log.info(parameter.toString());
		try(SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession()){
			Employer employer = sqlSession.selectOne(NAMESPACE + ".signIn", parameter);
			return Optional.ofNullable(employer);
		}
	}
	
	@Override
	public int signUp(Employer member) {
		// TODO Auto-generated method stub
		return 0;
	}
}
