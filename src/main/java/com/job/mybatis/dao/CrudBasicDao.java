package com.job.mybatis.dao;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.job.mybatis.SessionFactory;

public abstract class CrudBasicDao<T, PK> implements CrudDao<T, PK>{
	
	protected static SqlSessionFactory sqlSessionFactory = SessionFactory.getInstance();
	protected final String namespace;
	
	public CrudBasicDao(String namespace) { this.namespace = namespace; }
	
	/** 
	 * 객체를 db에 저장
	 */
	@Override
	public int insert(T obj) {
		return insert("insert", obj);
	}
	
	public int insert(String statementId, T obj) {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			int result = sqlSession.insert(namespace + "." + statementId, obj);
			sqlSession.commit();
			return result;
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return -1;
	}
	
	/** 
	 * 기본 키로 데이터 조회
	 * @return Optional<T>
	 */
	@Override
	public Optional<T> findById(PK pk) {
		return findById("findById", pk);
	}
	
	public Optional<T> findById(String statementId, PK pk) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()){
			T findObj = sqlSession.selectOne(namespace + "." + statementId, pk);
			Optional<T> opt = Optional.ofNullable(findObj);
			return opt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
