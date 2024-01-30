package com.jobboard.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpUtil {
	private static HttpUtil instance;
	
	public static HttpUtil getInstance() {
		if(instance == null) {
			instance = new HttpUtil();
		}
		return instance;
	}
	
	private final String viewDir = "/WEB-INF/views/";
	private final String fileType = ".jsp";
	
	public void forward(HttpServletRequest req, HttpServletResponse resp, String view) throws ServletException, IOException {
		String viewPath = this.viewDir + view + this.fileType;
		req.getRequestDispatcher(viewPath).forward(req, resp);
	}
}
