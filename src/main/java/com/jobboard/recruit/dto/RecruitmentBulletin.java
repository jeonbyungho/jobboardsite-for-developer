package com.jobboard.recruit.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.jobboard.dto.enums.JobTitle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class RecruitmentBulletin {
	private long id;
	
	private String title;
	private List<JobTitle> jobs;
	private String workLocation;
	private String content;
	
	private int minSalary, maxSalary;
	private List<String> skills;
	
	private String photosPath;
	
	private LocalDateTime createdAt, modifiedAt;
}
