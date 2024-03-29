package com.jobboard.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.auth.controller.SignInController;
import com.jobboard.auth.controller.SignUpController;
import com.jobboard.auth.controller.SignUpDuplicateCheckController;
import com.jobboard.etc.controller.AddressSearchController;
import com.jobboard.etc.controller.SimpleController;
import com.jobboard.recruit.controller.RecruitBullContorller;
import com.jobboard.recruit.controller.RecruitBullDetailContorller;
import com.jobboard.recruit.controller.RecruitBullWriteContorller;
import com.jobboard.web.WebURLPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "FrontControllerServlet", urlPatterns = {
		"/", WebURLPattern.SIGNIN, WebURLPattern.SIGNUP + "/*", WebURLPattern.SIGNUP_DUPLICATE
	,	WebURLPattern.RECRUIT_POSTLIST + "/*", WebURLPattern.RECRUIT_POSTDETAIL + "/*", WebURLPattern.RECRUIT_POSTWRITE
	,	WebURLPattern.ADDRESS_API_POPUP
	})
@MultipartConfig(fileSizeThreshold = 1024 * 1024
	,	maxFileSize =  -1
	,	maxRequestSize = -1
	)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Controller> controllerMap;
	
	@Override
	public void init() throws ServletException {
		controllerMap = new HashMap<String, Controller>();
		controllerMap.put("/", new SimpleController("welcome"));
		controllerMap.put(WebURLPattern.SIGNIN, new SignInController());
		controllerMap.put(WebURLPattern.SIGNUP, new SignUpController());
		controllerMap.put(WebURLPattern.SIGNUP_DUPLICATE, new SignUpDuplicateCheckController());
		
		controllerMap.put(WebURLPattern.RECRUIT_POSTLIST, new RecruitBullContorller());
		controllerMap.put(WebURLPattern.RECRUIT_POSTWRITE, new RecruitBullWriteContorller());
		controllerMap.put(WebURLPattern.RECRUIT_POSTDETAIL, new RecruitBullDetailContorller());
		
		controllerMap.put(WebURLPattern.ADDRESS_API_POPUP, new AddressSearchController());
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
		Controller controller = controllerMap.get(uri);
		
		if (controller == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		controller.execute(req, resp);
	}
}
