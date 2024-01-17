package com.job.domain.dto;

import java.time.LocalDate;

import com.job.enums.Gender;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter @Builder @ToString
public class Jobseeker {
	private long id;
	private Member member;
	
	private String name;
	private LocalDate birthday;
	private Gender gender;
}
