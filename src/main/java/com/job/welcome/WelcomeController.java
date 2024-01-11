package com.job.welcome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.mvc.controller.Controller;

public class WelcomeController implements Controller{

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "welcome";
	}

}
