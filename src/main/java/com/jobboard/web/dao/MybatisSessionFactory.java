package com.jobboard.web.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MybatisSessionFactory {
	
	private static SqlSessionFactory instance;
	
	public static SqlSessionFactory getInstance() {
		if(instance == null) {
			String resource = "mybatis/config.xml";
			try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
				instance = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
}
