package com.jobboard.auth.service;

import java.util.Optional;

import com.jobboard.auth.dao.EmployerDao;
import com.jobboard.auth.model.Employer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignInService {
	private static SignInService instance;
	
	public static SignInService getInstance() {
		if(instance == null) {
			instance = new SignInService();
		}
		return instance;
	}
	
	private final EmployerDao employerDao = EmployerDao.getInstance();
	
	public Optional<Employer> signIn(String username, String password){
		Optional<Employer> optEmpl = employerDao.signIn(username, password);
		return optEmpl;
	}
}
