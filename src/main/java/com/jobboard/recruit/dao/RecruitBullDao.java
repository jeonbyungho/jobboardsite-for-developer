package com.jobboard.recruit.dao;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jobboard.recruit.domain.RecruitmentBulletin;
import com.jobboard.web.mybatis.MybatisSessionFactory;

public class RecruitBullDao {
	private static RecruitBullDao instance;
	
	private RecruitBullDao() {}
	
	public static RecruitBullDao getInstance() {
		if(instance == null) {
			instance = new RecruitBullDao();
		}
		return instance;
	}
	
	private final String NAMESPACE = "RecruitmentBulletinMapper";
	private final SqlSessionFactory sqlSessionFactory = MybatisSessionFactory.getInstance();
	
	public Optional<RecruitmentBulletin> findById(long pk) {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			RecruitmentBulletin obj= sqlSession.selectOne(NAMESPACE + ".findById", pk);
			return Optional.ofNullable(obj);
		}
	}
	
	public int insert() {
		return -1;
	}
}
