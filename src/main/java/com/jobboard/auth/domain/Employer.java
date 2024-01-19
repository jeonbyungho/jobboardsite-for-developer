package com.jobboard.auth.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Employer{
	private long id;
	private String businessRegistrationNumber;
	private String companyName;
	private String address;
	private LocalDate foundingDate;
	
	private Member member;
}
