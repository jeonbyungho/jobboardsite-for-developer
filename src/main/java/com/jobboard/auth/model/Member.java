package com.jobboard.auth.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Member {
	private Long id;
	private String username;
	private String password;
	private String email;
	private LocalDateTime createdAt;

	public Member(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
