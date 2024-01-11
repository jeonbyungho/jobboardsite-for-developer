package com.job.mvc.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.job.user.LoginController;

@WebServlet(urlPatterns = "/")
public class FrontController extends AbstractFrontController{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		getControllerMap.put("/", new LoginController());
	}
}
