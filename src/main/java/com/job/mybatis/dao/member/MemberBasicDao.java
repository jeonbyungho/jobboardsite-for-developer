package com.job.mybatis.dao.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.job.mybatis.dao.CrudBasicDao;

public abstract class MemberBasicDao<T, PK> extends CrudBasicDao<T, PK> implements MemberDao<T, PK>{

	public MemberBasicDao(String namespace) {
		super(namespace);
	}
	
	@Override
	public Optional<T> findByUsername(String username) {
		return findByUsername("findByUsername", username);
	}
	
	public Optional<T> findByUsername(String statementId, String username) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()){
			T findObj = sqlSession.selectOne(namespace + "." + statementId, username);
			Optional<T> opt = Optional.ofNullable(findObj);
			return opt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	public Map<String, Object> findMap(PK pk) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()){
			HashMap<String, Object> findObj = sqlSession.selectOne(namespace + "." + "findMap", pk);
			return findObj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
