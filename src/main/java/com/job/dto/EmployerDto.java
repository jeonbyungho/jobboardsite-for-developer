package com.job.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter @Builder @ToString
public class EmployerDto implements Employer{
	private long id;
	private MemberDto member;
	
	private String companyName;

	@Override
	public String getUsername() { return member.getUsername(); }
	
	@Override
	public String getPassword() { return member.getPassword();}
	
}
