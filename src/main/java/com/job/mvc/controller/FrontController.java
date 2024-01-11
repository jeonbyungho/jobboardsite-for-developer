package com.job.mvc.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.job.jobpost.JobPostDetailController;
import com.job.jobpost.JobPostListController;
import com.job.user.LoginController;
import com.job.welcome.WelcomeController;

@WebServlet(urlPatterns = "/")
public class FrontController extends AbstractFrontController{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		getControllerMap.put("/", new WelcomeController());
		getControllerMap.put("/login", new LoginController());
		
		JobPostListController jobPostList = new JobPostListController();
		getControllerMap.put("/jobpost/", jobPostList);
		getControllerMap.put("/jobpost/list", jobPostList);
		
		getControllerMap.put("/jobpost/detail/", new JobPostDetailController());
	}
}
