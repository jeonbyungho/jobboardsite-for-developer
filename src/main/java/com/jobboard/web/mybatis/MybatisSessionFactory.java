package com.jobboard.web.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSessionFactory {
	
	private static SqlSessionFactory instance;
	
	private MybatisSessionFactory() {}
	
	public static SqlSessionFactory getInstance() {
		if(instance == null) {
			String resource = "com/jobboard/web/mybatis/config.xml";
			try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
				instance = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
}
