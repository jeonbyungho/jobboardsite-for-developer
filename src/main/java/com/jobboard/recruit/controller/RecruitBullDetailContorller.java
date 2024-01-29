package com.jobboard.recruit.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.recruit.domain.RecruitmentBulletin;
import com.jobboard.recruit.service.RecruitBullService;
import com.jobboard.web.controller.ControllerImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecruitBullDetailContorller extends ControllerImpl{
	private final String viewPath = "recruit/recruitBull_detail";
	private final RecruitBullService rbService = RecruitBullService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String info = req.getPathInfo().substring(1);
		Long id = null;
		
		try {
			id = Long.parseLong(info);
		} catch (NumberFormatException e) {
			log.error(e.getMessage());
			return;
		} catch (NullPointerException e) {
			log.error(e.getMessage());
			return;
		}
		
		Optional<RecruitmentBulletin> optRb = rbService.getRecruiBull(id);
		if (optRb.isPresent()) {
			RecruitmentBulletin rb = optRb.get();
			req.setAttribute("recruitbull", rb);
			getJspForward(req, resp, viewPath);
			return;
		}
		
	}
}
