package com.jobboard.recruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.dto.PagingDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecruitBullContorller extends ControllerImpl {
	
	private final String viewPath = "recruit/recruitBull_list";
	private final int countItemPerPage = 16;
	private final int sizePage = 10;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = null;
		
		try {
			id = Integer.parseInt(req.getPathInfo().substring(1));
		} catch (NumberFormatException e) {
			log.error(e.getMessage());
			return;
		} catch (NullPointerException e) {
			log.error(e.getMessage());
			id = 1;
		}
		
		PagingDto page = new PagingDto(1000, countItemPerPage, sizePage, id);
		req.setAttribute("pagingDto", page);
		getJspForward(req, resp, viewPath);
	}

}