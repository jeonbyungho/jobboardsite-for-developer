package com.job.mybatis.dao;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.job.mybatis.SqlMapConfig;
import com.job.mybatis.vo.UserVO;

public class UserDAO implements CuidDAO<UserVO, Long>{
	
	private static SqlSessionFactory sqlSessionFactory = SqlMapConfig.getInstance();
	private static UserDAO instance = new UserDAO();
	
	private UserDAO() {}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	public Optional<UserVO> findByUsername(String username) {
		Optional<UserVO> optUser = Optional.empty();
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			UserVO findUser = sqlSession.selectOne("UserMapper.findByUsername", username);
			optUser = Optional.ofNullable(findUser);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return optUser;
	}

	@Override
	public int save(UserVO obj) {
		int result = 0;
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			result = sqlSession.insert("UserMapper.save", obj);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Optional<UserVO> findById(Long primaryKey) {
		Optional<UserVO> optUser = Optional.empty();
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			UserVO findUser = sqlSession.selectOne("UserMapper.findById", primaryKey);
			optUser = Optional.ofNullable(findUser);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return optUser;
	}
	
}
