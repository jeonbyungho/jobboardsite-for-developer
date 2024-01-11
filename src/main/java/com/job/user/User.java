package com.job.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	private long id;
	private String username;
	private String password;
	private String email;
	private String createdDate;

}