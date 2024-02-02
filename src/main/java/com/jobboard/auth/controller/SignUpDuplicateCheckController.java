package com.jobboard.auth.controller;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.auth.service.SignUpService;
import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.HttpUtil;

public class SignUpDuplicateCheckController extends ControllerImpl{
	private final SignUpService signUpService = SignUpService.getInstance();
	private final HttpUtil httUtil = HttpUtil.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("username");
		boolean result = signUpService.checkDuplicateUsername(username);
		System.out.println(result);
		Map<String, Object> mag = new HashMap<>();
		mag.put("result", result);

		httUtil.responseJson(resp, mag);
	}
}
