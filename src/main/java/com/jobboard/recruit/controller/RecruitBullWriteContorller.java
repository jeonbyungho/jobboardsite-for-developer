package com.jobboard.recruit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

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
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		writeService.write(title, content);
		
		Part imgPart =  req.getPart("image");
		if (imgPart.getSize() > 0) {
			String imgPath = req.getServletContext().getRealPath(WebURLPattern.RECRUIT_POST_IMAGEPATH) 
					+ "/" + LocalDate.now().getYear()
					+ "/" + LocalDate.now().getMonthValue()
					+ "/" + LocalDate.now().getDayOfMonth();
			writeService.storeImage(imgPart.getInputStream(), imgPath, imgPart.getSubmittedFileName());
		}
		
		PrintWriter out = resp.getWriter();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("success", false);
		out.print(jsonObj.toJSONString());
		out.close();
	}
}
