package com.job.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	
	private static SqlSessionFactory instance;
	
	private SessionFactory() {}
	
	public static SqlSessionFactory getInstance() {
		if(instance == null) {
			String resource = "com/job/mybatis/mybatis-config.xml";
			try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
				instance = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
}
