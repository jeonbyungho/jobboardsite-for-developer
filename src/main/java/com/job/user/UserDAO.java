package com.job.user;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.job.mvc.dao.CuidDAO;
import com.job.mvc.dao.SqlMapConfig;

public class UserDAO implements CuidDAO<User, Long>{
	
	private static SqlSessionFactory sqlSessionFactory = SqlMapConfig.getInstance();
	private static UserDAO instance = new UserDAO();
	
	private UserDAO() {}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	public Optional<User> findByUsername(String username) {
		Optional<User> optUser = Optional.empty();
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			User findUser = sqlSession.selectOne("UserMapper.findByUsername", username);
			optUser = Optional.ofNullable(findUser);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return optUser;
	}

	@Override
	public int save(User obj) {
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
	public Optional<User> findById(Long primaryKey) {
		Optional<User> optUser = Optional.empty();
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			User findUser = sqlSession.selectOne("UserMapper.findById", primaryKey);
			optUser = Optional.ofNullable(findUser);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return optUser;
	}
	
}
