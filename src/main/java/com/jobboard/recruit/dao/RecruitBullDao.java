package com.jobboard.recruit.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jobboard.dto.Pagination;
import com.jobboard.mybatis.MybatisSessionFactory;
import com.jobboard.recruit.dto.RecruitmentBulletin;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecruitBullDao {
	private static RecruitBullDao instance;
	
	public static RecruitBullDao getInstance() {
		if(instance == null) {
			instance = new RecruitBullDao();
		}
		return instance;
	}
	
	private final String NAMESPACE = "RecruitmentBulletinMapper";
	private final SqlSessionFactory sqlSessionFactory = MybatisSessionFactory.getInstance();
	
	/** 게시판 조회 */
	public Optional<RecruitmentBulletin> findById(Long pk) {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			RecruitmentBulletin obj= sqlSession.selectOne(NAMESPACE + ".findById", pk);
			return Optional.ofNullable(obj);
		}
	}
	
	/** 게시판 총 개수 */
	public long count() {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			return sqlSession.selectOne(NAMESPACE + ".count");
		}
	}
	
	/** 게시판 목록 조회 */
	public List<RecruitmentBulletin> findAllByPaging(Pagination pagination){
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			List<RecruitmentBulletin> list = sqlSession.selectList(NAMESPACE + ".findAll", pagination);
			return list;
		}
	}
	
	/** 게시판 작성 */
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
