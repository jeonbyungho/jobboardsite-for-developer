package com.jobboard.test;

import org.junit.Test;

import com.jobboard.auth.dao.BusinessMemberDao;
import com.jobboard.auth.service.SignUpService;
import com.jobboard.dto.recruit.JobBoard;
import com.jobboard.recruit.dao.JobBoardDao;


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

	@Test
	public void jobboardDao(){
		JobBoardDao dao = JobBoardDao.getInstance();
		dao.findById(1l).ifPresent(jb -> System.out.println(jb.toString()));
	}
}