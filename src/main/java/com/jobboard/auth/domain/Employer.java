package com.jobboard.auth.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Employer{
	private long id;
	private String businessNumber;	// 사업자등록번호
	private String companyName;	// 기업명
	private String address;	// 회사 주소
	private LocalDate foundingDate;	// 설립일
	
	private Member member;
}
