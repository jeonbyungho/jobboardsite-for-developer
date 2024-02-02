package com.jobboard.recruit.dao;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jobboard.dto.recruit.JobBoard;
import com.jobboard.mybatis.MybatisSessionFactory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JobBoardDao {
    private static JobBoardDao instance;
	
	public static JobBoardDao getInstance() {
		if(instance == null) {
			instance = new JobBoardDao();
		}
		return instance;
	}

    private final String NAMESPACE = "recruit.JobBoard";
    private final SqlSessionFactory sqlSessionFactory = MybatisSessionFactory.getInstance();

    public Optional<JobBoard> findById(Long pk){
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            JobBoard obj = sqlSession.selectOne(NAMESPACE + ".findById", pk);
            return Optional.ofNullable(obj);
        }
    }
}
