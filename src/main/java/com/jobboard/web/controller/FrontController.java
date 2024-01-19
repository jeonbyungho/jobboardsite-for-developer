package com.jobboard.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.auth.controller.SignInContoller;
import com.jobboard.auth.controller.SignUpContoller;
import com.jobboard.auth.controller.SignUpDuplicateCheckController;
import com.jobboard.auth.controller.WelcomeContoller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "FrontControllerServlet", urlPatterns = {
		"/", WebURLPattern.SIGNIN, WebURLPattern.SIGNUP_EMPLOYER, WebURLPattern.SIGNUP_JOBSEEKER, WebURLPattern.SIGNUP_DUPLICATE
	,	WebURLPattern.RECRUIT_POSTLIST, WebURLPattern.RECRUIT_POSTDETAIL, WebURLPattern.RECRUIT_POSTWRITE
	})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Controller> controllerMap;
	
	@Override
	public void init() throws ServletException {
		controllerMap = new HashMap<String, Controller>();
		controllerMap.put("/", new WelcomeContoller());
		controllerMap.put(WebURLPattern.SIGNIN, new SignInContoller());
		Controller signUpContoller = new SignUpContoller();
		controllerMap.put(WebURLPattern.SIGNUP_EMPLOYER, signUpContoller);
		controllerMap.put(WebURLPattern.SIGNUP_JOBSEEKER, signUpContoller);
		controllerMap.put(WebURLPattern.SIGNUP_DUPLICATE, new SignUpDuplicateCheckController());
		log.info("FrontController 생성");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getServletPath();
		log.info(uri);
		Controller controller = controllerMap.get(uri);
		
		if (controller == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		controller.execute(req, resp);
	}
}
