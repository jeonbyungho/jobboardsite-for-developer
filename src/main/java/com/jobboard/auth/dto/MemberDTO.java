package com.jobboard.auth.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class MemberDTO {
	private Long id;
	private String username;
	private String password;
	private String email;
	private LocalDateTime createdAt;

	public MemberDTO(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
