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
import com.jobboard.web.controller.ControllerImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignUpContoller extends ControllerImpl {
	private final String signInViewPath = "auth/signUp_empl";
	private final SignUpService signUpService = SignUpService.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (METHOD_GET.equals(method)) {
			getJspForward(req, resp, signInViewPath);
		}
		else if (METHOD_POST.equals(method)) {
			signUp(req, resp);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> signUpParameterMap = req.getParameterMap();
		Map<String, Object> memberInfos = new HashMap<>();
		for (String key: signUpParameterMap.keySet()) {
			memberInfos.put(key, String.join("", signUpParameterMap.get(key)));
		}
		int result = signUpService.signUp(memberInfos);
		log.info("고용주 가입 결과:"+ result);
		
		PrintWriter out = resp.getWriter();
		JSONObject jsonObj = new JSONObject();
		boolean confirmSuccess = false;
		if(result > 0) {
			confirmSuccess = true;
		}
		jsonObj.put("success", confirmSuccess);
		out.print(jsonObj.toJSONString());
		out.close();
	}
}
