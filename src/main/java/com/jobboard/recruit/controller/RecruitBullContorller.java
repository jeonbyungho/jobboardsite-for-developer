package com.jobboard.recruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.recruit.model.RecruitmentBulletin;
import com.jobboard.recruit.service.RecruitBullService;
import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.HttpUtil;
import com.jobboard.web.model.ResultPage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecruitBullContorller extends ControllerImpl {
	
	private final String viewPath = "recruit/recruitBull_list";
	private final int countItemPerPage = 16;
	private final int sizePage = 10;
	
	private final RecruitBullService rbService = RecruitBullService.getInstance();
	private final HttpUtil httUtil = HttpUtil.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer page = 1;
		
		try {
			page = Integer.parseInt(req.getPathInfo().substring(1));
		} catch (NumberFormatException e) {
			log.error(e.getMessage());
			return;
		} catch (NullPointerException e) {
			log.error(e.getMessage());
		}
		
		ResultPage<RecruitmentBulletin> rbsPaging = rbService.getRecruiBullAll(countItemPerPage, sizePage, page).orElseThrow();
		System.out.println(rbsPaging.getList().toString());
		req.setAttribute("recruitBulls", rbsPaging.getList());
		req.setAttribute("pagination", rbsPaging.getPage());
		httUtil.forward(req, resp, viewPath);
	}

}