package com.jobboard.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleContoller extends ControllerImpl{
	private final String viewPath;
	private final HttpUtil httUtil = HttpUtil.getInstance();
	
	public SimpleContoller(String viewPath) {
		this.viewPath = viewPath;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		httUtil.forward(req, resp, viewPath);
	}
}