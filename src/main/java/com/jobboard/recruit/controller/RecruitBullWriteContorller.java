package com.jobboard.recruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.web.controller.ControllerImpl;

public class RecruitBullWriteContorller extends ControllerImpl{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getJspForward(req, resp, "recruit/recruitBull_form");
	}
}
