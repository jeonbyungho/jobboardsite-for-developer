package com.jobboard.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ControllerImpl implements Controller{
	private static final String VIEWS_DIR = "/WEB-INF/views/";
	private static final String FILE_TYPE = ".jsp";
	
	protected static final String METHOD_GET = "GET";
	protected static final String METHOD_POST = "POST";
	protected static final String METHOD_PUT = "PUT";
	protected static final String METHOD_DELETE = "DELETE";
	
	protected void getJspForward(
			HttpServletRequest req, HttpServletResponse resp, String view) 
			throws ServletException, IOException {
		String viewPath = VIEWS_DIR + view + FILE_TYPE;
		req.getRequestDispatcher(viewPath).forward(req, resp);
	}
}