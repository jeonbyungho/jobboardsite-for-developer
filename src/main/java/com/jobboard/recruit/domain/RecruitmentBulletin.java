package com.jobboard.recruit.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.jobboard.auth.domain.Employer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class RecruitmentBulletin {
	private long id;
	private Employer employer;
	
	private String title;
	private List<RecruitmentJob> jobs;
	private String workLocation;
	private String content;
	
	private int minSalary, maxSalary;
	private List<String> skills;
	
	private List<String> images;
	
	private LocalDateTime createdAt, modifiedAt;
}
