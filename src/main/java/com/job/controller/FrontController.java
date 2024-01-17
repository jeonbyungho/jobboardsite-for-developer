package com.job.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.job.controller.jobpost.*;
import com.job.controller.member.JoinContorller;
import com.job.controller.member.LoginController;
import com.job.controller.welcome.WelcomeController;

@WebServlet(urlPatterns = "/")
public class FrontController extends AbstractFrontController{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		getControllerMap.put("/", new WelcomeController());
		getControllerMap.put("/login", new LoginController());
		getControllerMap.put("/join", new JoinContorller());
		
		JobPostListController jobPostList = new JobPostListController();
		getControllerMap.put("/jobpost/", jobPostList);
		getControllerMap.put("/jobpost/list", jobPostList);
		
		getControllerMap.put("/jobpost/detail/", new JobPostDetailController());
		
		getControllerMap.put("/jobpost/wirte", new JobPostingController());
	}
}
