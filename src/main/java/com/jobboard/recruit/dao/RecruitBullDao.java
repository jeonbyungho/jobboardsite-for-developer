package com.jobboard.recruit.dao;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jobboard.recruit.domain.RecruitmentBulletin;
import com.jobboard.web.dao.MybatisSessionFactory;

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
	
	public int insert(RecruitmentBulletin recruitBull) {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.insert(NAMESPACE + ".insert", recruitBull);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			sqlSession.close();
		}
		return -1;
	}
}
