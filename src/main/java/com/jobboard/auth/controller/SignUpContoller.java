package com.jobboard.auth.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.web.controller.ControllerImpl;

public class SignUpContoller extends ControllerImpl {
	private final String signInViewPath = "account/signUp";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (METHOD_GET.equals(method)) {
			getJspForward(req, resp, signInViewPath);
		}
	}
}
