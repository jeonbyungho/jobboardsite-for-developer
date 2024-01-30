package com.jobboard.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

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
	
	public void responseJson(HttpServletResponse resp, Map<String, Object> msg) throws IOException {
		resp.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject(msg);
		PrintWriter out = resp.getWriter();
		out.println(json.toJSONString());
		out.close();
	}
}
