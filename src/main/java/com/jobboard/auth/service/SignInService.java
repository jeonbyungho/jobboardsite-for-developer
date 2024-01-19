package com.jobboard.auth.service;

import java.util.Optional;

import com.jobboard.auth.dao.EmployerDao;
import com.jobboard.auth.domain.Employer;

public class SignInService {
	private static SignInService instance;
	
	private SignInService() {}
	
	public static SignInService getInstance() {
		if(instance == null) {
			instance = new SignInService();
		}
		return instance;
	}
	
	public Optional<Employer> signIn(String username, String password){
		EmployerDao emplDao = EmployerDao.getInstance();
		Optional<Employer> optEmpl = emplDao.signIn(username, password);
		return optEmpl;
	}
}
