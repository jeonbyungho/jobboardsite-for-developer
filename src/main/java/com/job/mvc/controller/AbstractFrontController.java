package com.job.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractFrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected Map<String, Controller> getControllerMap;
	protected Map<String, Controller> postControllerMap;
	
	@Override
	public void init() throws ServletException {
		getControllerMap = new HashMap<>();
		postControllerMap = new HashMap<>();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp, getControllerMap);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp, postControllerMap);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp, Map<String, Controller> controllerMap) 
			throws ServletException, IOException {
		String servletPath = req.getServletPath();
		Controller controller = controllerMap.get(servletPath);
		
		if (controller == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		String viewName = controller.excute(req, resp);
		String viewPath = "/WEB-INF/views/"+ viewName +".jsp";
		req.getRequestDispatcher(viewPath).forward(req, resp);
	}
}
