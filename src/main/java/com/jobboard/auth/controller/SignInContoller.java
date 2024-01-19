package com.jobboard.auth.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobboard.auth.domain.Employer;
import com.jobboard.auth.service.SignInService;
import com.jobboard.web.controller.ControllerImpl;

public class SignInContoller extends ControllerImpl{
	private final String signInViewPath = "auth/signIn";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (METHOD_GET.equals(method)) {
			getJspForward(req, resp, signInViewPath);
			return;
		}
		else if (METHOD_POST.equals(method)) {
			SignInService signInService = SignInService.getInstance();
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			Optional<Employer> optEmpl = signInService.signIn(username, password);
			
			if(optEmpl.isPresent()) {
				Employer employer = optEmpl.get();
				HttpSession session = req.getSession();
				session.setAttribute("member", employer);
				resp.sendRedirect("/");
				return;
			}
			getJspForward(req, resp, signInViewPath);
		}
	}
}