package com.jobboard.auth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.jobboard.auth.service.SignUpService;
import com.jobboard.web.WebURLPattern;
import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.HttpUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignUpContoller extends ControllerImpl {
	private final String emplViewPath = "auth/signUp_empl";
	private final String seekerViewPath = "auth/signUp_empl";
	private final SignUpService signUpService = SignUpService.getInstance();
	private final HttpUtil httUtil = HttpUtil.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(pathInfo.equals(WebURLPattern.EMPLOYER)) {
			httUtil.forward(req, resp, emplViewPath);
		} else if(pathInfo.equals(WebURLPattern.JOBSEEKER)) {
			httUtil.forward(req, resp, seekerViewPath);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(pathInfo.equals(WebURLPattern.EMPLOYER)) {
			employerSignUp(req, resp);
		} else if(pathInfo.equals(WebURLPattern.JOBSEEKER)) {
			employerSignUp(req, resp);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void employerSignUp(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
		Map<String, String[]> signUpParameterMap = req.getParameterMap();
		Map<String, Object> memberInfos = new HashMap<>();
		for (String key: signUpParameterMap.keySet()) {
			memberInfos.put(key, String.join("", signUpParameterMap.get(key)));
		}
		int result = signUpService.signUp(memberInfos);
		log.info("고용주 가입 결과:"+ result);
		
		Map<String, Object> json = new JSONObject();
		json.put("success", result > 0);
		httUtil.responseJson(resp, json);
	}
}
