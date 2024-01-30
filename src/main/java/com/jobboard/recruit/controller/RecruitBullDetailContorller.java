package com.jobboard.recruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.recruit.domain.RecruitmentBulletin;
import com.jobboard.recruit.service.RecruitBullService;
import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.HttpUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecruitBullDetailContorller extends ControllerImpl{
	private final String viewPath = "recruit/recruitBull_detail";
	private final RecruitBullService rbService = RecruitBullService.getInstance();
	private final HttpUtil httUtil = HttpUtil.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = null;
		
		try {
			id = Long.parseLong(req.getPathInfo().substring(1));
		} catch (NumberFormatException e) {
			log.error(e.getMessage());
			return;
		} catch (NullPointerException e) {
			log.error(e.getMessage());
			return;
		}
		
		RecruitmentBulletin rb = rbService.getRecruiBull(id).orElseThrow();
		req.setAttribute("recruitbull", rb);
		httUtil.forward(req, resp, viewPath);
		return;
		
	}
}
