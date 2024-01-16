package com.job.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class JobpostDto {
	private long id;
	private EmployerDto author;
	
	private String title;
	private String workAddress;
	private String content;
	
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
}
