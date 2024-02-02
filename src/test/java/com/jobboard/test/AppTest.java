package com.jobboard.test;

import org.junit.Test;

import com.jobboard.auth.dao.BusinessMemberDao;
import com.jobboard.auth.service.SignUpService;


public class AppTest {
	
	@Test
	public void dao(){
		BusinessMemberDao dao = BusinessMemberDao.getInstance();
		long count = dao.checkDuplicateUsername("test1");
		System.out.println(count);
	}

	@Test
	public void service(){
		SignUpService sv = SignUpService.getInstance();
		boolean bl = sv.checkDuplicateUsername("test3");
		System.out.println(bl);
	}
}