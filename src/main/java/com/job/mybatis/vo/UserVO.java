package com.job.mybatis.vo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class UserVO {
	private long id;
	private String username;
	private String password;
	private String email;
	private LocalDateTime createdDate;

}