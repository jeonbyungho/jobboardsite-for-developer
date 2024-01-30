package com.jobboard.auth.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobboard.auth.model.Employer;
import com.jobboard.auth.service.SignInService;
import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.HttpUtil;
import com.jobboard.web.model.ResultMessage;

public class SignInContoller extends ControllerImpl{
	private final String viewPath = "auth/signIn";
	private final SignInService signInService = SignInService.getInstance();
	private final HttpUtil httUtil = HttpUtil.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		httUtil.forward(req, resp, viewPath);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		ResultMessage<Employer> rs = signInService.signIn(username, password);
		
		HttpSession session = req.getSession();
		session.setAttribute("member", rs.getValue());
		httUtil.responseJson(resp, rs.getMessage());
	}
}