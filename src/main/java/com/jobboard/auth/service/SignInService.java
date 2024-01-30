package com.jobboard.auth.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.jobboard.auth.dao.EmployerDao;
import com.jobboard.auth.model.Employer;
import com.jobboard.web.model.ResultMessage;

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
	
	public ResultMessage<Employer> signIn(String username, String password){
		Optional<Employer> opt = employerDao.signIn(username, password);
		Map<String, Object> msg = new HashMap<>();
		
		msg.put("success", opt.isPresent());
		if(opt.isEmpty()) {
			msg.put("error", "아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.");
		}
		
		return new ResultMessage<Employer>(opt.orElse(null), msg);
	}
}
