package com.jobboard.auth.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.auth.dto.BusinessMemberDTO;
import com.jobboard.auth.dto.MemberDTO;
import com.jobboard.auth.service.SignUpService;
import com.jobboard.web.WebURLPattern;
import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.HttpUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignUpController extends ControllerImpl {
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
	
	private void employerSignUp(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
		String companyType = req.getParameter("companyType");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String companyName = req.getParameter("companyName");
		String ceoName = req.getParameter("ceoName");
		
		MemberDTO member = new MemberDTO(username, password, email);
		BusinessMemberDTO businessMember = new BusinessMemberDTO();
		businessMember.setCompanyName(companyName);
		businessMember.applyCompanyType(companyType);
		businessMember.setMember(member);
		businessMember.setCeoName(ceoName);
		boolean result = signUpService.signUp(businessMember);
		
		Map<String, Object> json = new HashMap<>();
		json.put("result", result);
		json.put("profile", businessMember.toString());
		httUtil.responseJson(resp, json);
	}
}
