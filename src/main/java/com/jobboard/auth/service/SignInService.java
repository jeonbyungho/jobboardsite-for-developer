package com.jobboard.auth.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.jobboard.auth.dao.BusinessMemberDao;
import com.jobboard.dto.ResultMessage;
import com.jobboard.dto.member.BusinessMember;
import com.jobboard.web.PasswordEncryptionUtil;

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

	private final BusinessMemberDao bizMemberDao = BusinessMemberDao.getInstance();
	
	public ResultMessage<BusinessMember> signIn(String username, String password){
		PasswordEncryptionUtil pwEncrypt = PasswordEncryptionUtil.getInstance();
		Optional<BusinessMember> opt = bizMemberDao.signIn(username, pwEncrypt.encrypt(password));
		Map<String, Object> msg = new HashMap<>();
		
		boolean isValue = opt.isPresent();
		msg.put("success", isValue);
		if(!isValue) {
			msg.put("error", "아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.");
		}
		
		return new ResultMessage<BusinessMember>(opt.orElse(null), msg);
	}
}
