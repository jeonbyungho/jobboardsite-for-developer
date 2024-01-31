package com.jobboard.etc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.HttpUtil;

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