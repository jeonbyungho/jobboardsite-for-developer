package com.jobboard.auth.service;

import com.jobboard.auth.dao.BusinessMemberDao;
import com.jobboard.auth.dao.EmployerDao;
import com.jobboard.auth.model.BusinessMember;

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
	private final BusinessMemberDao businessMemberDao = BusinessMemberDao.getInstance();
	
	public int signUp(BusinessMember businessMember) {
        return businessMemberDao.signUp(businessMember);
    }
	
	public boolean checkUsernameDuplicate(String username) {
		int count = employerDao.checkUsernameDuplicate(username);
		return count > 0;
	}
}
