package com.job.user;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.mvc.controller.Controller;

public class LoginController implements Controller{
	@Override
	public String excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO dao = UserDAO.getInstance();
		String username = req.getParameter("username");
		Optional<User> optUser = dao.findByUsername(username);
		
		if (optUser.isPresent()) {
			User user = optUser.get();
			System.out.println(user.toString());
		} else {
			System.out.println("존재하지 않는 이름");
		}
		
		return "user/login";
	}
}
