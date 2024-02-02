package com.jobboard.recruit.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import com.jobboard.recruit.dto.RecruitmentBulletin;
import com.jobboard.recruit.service.RecruitBullService;
import com.jobboard.web.WebURLPattern;
import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.HttpUtil;

public class RecruitBullWriteContorller extends ControllerImpl{
	private final String viewPath = "recruit/recruitBull_form";
	private final RecruitBullService rbService = RecruitBullService.getInstance();
	private final HttpUtil httUtil = HttpUtil.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		httUtil.forward(req, resp, viewPath);
	}
	
	@Override @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RecruitmentBulletin recruitBull = new RecruitmentBulletin();
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		recruitBull.setTitle(title);
		recruitBull.setContent(content);
		
		List<InputStream> photoInputStreams = new ArrayList<InputStream>();
		
		for(Iterator<Part> parts = req.getParts().iterator(); parts.hasNext();) {
			Part part = parts.next();
			if(part.getName().equals("photos") && part.getContentType().equals("image/jpeg")) {
				photoInputStreams.add(part.getInputStream());
			}
		}
		
		if(photoInputStreams.size() > 0) {
			String photoPath = req.getServletContext().getRealPath(WebURLPattern.RECRUIT_POST_IMAGEPATH) 
					+ "/" + LocalDate.now().getYear()
					+ "/" + LocalDate.now().getMonthValue()
					+ "/" + LocalDate.now().getDayOfMonth();
			recruitBull.setPhotosPath(photoPath);
			rbService.write(recruitBull, photoInputStreams);
		} else {
			rbService.write(recruitBull);
		}
		
		PrintWriter out = resp.getWriter();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("success", false);
		out.print(jsonObj.toJSONString());
		out.close();
	}
}
