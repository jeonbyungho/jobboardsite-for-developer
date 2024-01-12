package com.job.controller.jobpost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.controller.Controller;

public class JobPostListController implements Controller{

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "jobpost/jobpost_list";
	}

}
