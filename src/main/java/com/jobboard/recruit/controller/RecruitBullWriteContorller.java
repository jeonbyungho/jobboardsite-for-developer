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

import com.jobboard.recruit.domain.RecruitmentBulletin;
import com.jobboard.recruit.service.RecruitBullWriteService;
import com.jobboard.web.controller.ControllerImpl;
import com.jobboard.web.controller.WebURLPattern;

public class RecruitBullWriteContorller extends ControllerImpl{
	private final String signInViewPath = "recruit/recruitBull_form";
	private final RecruitBullWriteService writeService = RecruitBullWriteService.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(METHOD_GET.equals(req.getMethod())) {
			getJspForward(req, resp, signInViewPath);
		} else if(METHOD_POST.equals(req.getMethod())) {
			recruitBullWrite(req, resp);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void recruitBullWrite(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
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
			writeService.write(recruitBull, photoInputStreams);
		} else {
			writeService.write(recruitBull);
		}
		
		PrintWriter out = resp.getWriter();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("success", false);
		out.print(jsonObj.toJSONString());
		out.close();
	}
}
