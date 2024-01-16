package com.job.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Builder @ToString
public class MemberDto {
	private long id;
	private String username;
	private String password;
	private String email;
	private LocalDateTime createdDate;
}
