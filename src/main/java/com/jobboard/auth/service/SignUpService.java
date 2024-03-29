package com.jobboard.auth.service;

import com.jobboard.auth.dao.BusinessMemberDao;
import com.jobboard.dto.member.BusinessMember;
import com.jobboard.dto.member.Member;
import com.jobboard.web.PasswordEncryptionUtil;

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

	private final BusinessMemberDao bizMemberDao = BusinessMemberDao.getInstance();

	public boolean signUp(BusinessMember businessMember) {
		PasswordEncryptionUtil pwEncrypt = PasswordEncryptionUtil.getInstance();
		Member member = businessMember.getMember();
		member.setPassword(pwEncrypt.encrypt(member.getPassword()));

        return bizMemberDao.signUp(businessMember);
    }
	
	public boolean checkDuplicateUsername(String username) {
		return 0 < bizMemberDao.checkDuplicateUsername(username);
	}
}
