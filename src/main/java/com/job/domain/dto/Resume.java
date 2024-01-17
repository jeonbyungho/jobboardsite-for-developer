package com.job.domain.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Resume {
	private long id;
	private Jobseeker jobseeker;
	
	private String title;
	private String content;
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
