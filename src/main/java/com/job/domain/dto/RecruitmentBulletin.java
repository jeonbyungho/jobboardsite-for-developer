package com.job.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.job.enums.RecruitmentJob;

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
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
