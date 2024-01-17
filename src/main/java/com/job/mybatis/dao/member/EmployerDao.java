package com.job.mybatis.dao.member;

import com.job.domain.dto.Employer;

public class EmployerDao extends MemberBasicDao<Employer, Long>{
	
	private static EmployerDao instance;
	
	private EmployerDao() {
		super("EmployerMapper");
	}
	
	public static EmployerDao getInstance() {
		if(instance == null) { instance = new EmployerDao(); }
		return instance;
	}
}
