package com.jobboard.auth.service;

import java.util.Map;

import com.jobboard.auth.dao.EmployerDao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpService {
	private static SignUpService instance;
	
	public static SignUpService getInstance() {
		if(instance == null) {
			instance = new SignUpService();
		}
		return instance;
	}
	
	private final EmployerDao employerDao = EmployerDao.getInstance();
	
	public int signUp(Map<String, Object> memberInfos){
		return employerDao.signUp(memberInfos);
	}
	
	public boolean duplicateUsername(String username) {
		int count = employerDao.duplicateUsername(username);
		return count > 0;
	}
}
