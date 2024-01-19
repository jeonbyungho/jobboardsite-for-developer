package com.jobboard.auth.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.jobboard.auth.service.SignUpService;
import com.jobboard.web.controller.ControllerImpl;

public class SignUpDuplicateCheckController extends ControllerImpl{
	private final SignUpService signUpService = SignUpService.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (METHOD_POST.equals(method)) {
			duplicateUsername(req, resp);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void duplicateUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("username");
		boolean result = signUpService.duplicateUsername(username);
		
		PrintWriter out = resp.getWriter();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("duplicate", result);
		out.print(jsonObj.toJSONString());
		out.close();
	}
}
