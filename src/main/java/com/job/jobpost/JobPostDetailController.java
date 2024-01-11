package com.job.jobpost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.mvc.controller.Controller;

public class JobPostDetailController implements Controller{

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "jobpost/jobpost_detail";
	}

}
