package com.jobboard.auth.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Member {
	private long id;
	private String username;	// 아이디, 유저이름
	private String password;	// 비밀번호
	private MemberType memberType;	// 회원 타입
	private String email;	// 이메일
	private LocalDateTime createdAt;	// 생성 날짜
}
