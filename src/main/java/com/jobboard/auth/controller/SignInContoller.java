package com.jobboard.auth.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.jobboard.auth.domain.Employer;
import com.jobboard.auth.service.SignInService;
import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.HttpUtil;

public class SignInContoller extends ControllerImpl{
	private final String viewPath = "auth/signIn";
	private final SignInService signInService = SignInService.getInstance();
	private final HttpUtil httUtil = HttpUtil.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		httUtil.forward(req, resp, viewPath);
	}
	
	@Override @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		JSONObject jsonObj = new JSONObject();
		boolean confirmSuccess = false;

		Employer employer = signInService.signIn(username, password).orElseThrow();
		HttpSession session = req.getSession();
		session.setAttribute("member", employer);
		confirmSuccess = true;
		jsonObj.put("profile", employer.toString());

		jsonObj.put("success", confirmSuccess);
		out.print(jsonObj.toJSONString());
		out.close();
	}
}