package com.jobboard.web;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomTagss extends SimpleTagSupport {
	
	private String title;
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println(title);
		getJspBody().invoke(null);
	}
}
