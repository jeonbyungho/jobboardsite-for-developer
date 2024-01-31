package com.jobboard.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		long startTime = System.currentTimeMillis();
		HttpServletRequest httpReq = (HttpServletRequest) req;
		chain.doFilter(req, resp);
		long endTime = System.currentTimeMillis();
		log.debug("{} \"{}\" \"{}\" {}ms", httpReq.getMethod(), httpReq.getServletPath(), httpReq.getPathInfo(), endTime - startTime);
	}
	
}
