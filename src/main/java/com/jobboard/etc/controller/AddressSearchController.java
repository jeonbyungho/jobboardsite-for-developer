package com.jobboard.etc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.HttpUtil;

public class AddressSearchController extends ControllerImpl{
	
	private final String viewPath = "popup/jusoPopup";
	private final HttpUtil httUtil = HttpUtil.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.httUtil.forward(req, resp, viewPath);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.httUtil.forward(req, resp, viewPath);
	}
}
