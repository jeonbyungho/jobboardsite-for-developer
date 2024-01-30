package com.jobboard.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter @AllArgsConstructor @ToString
public enum MemberType {
	EMPLOYER(1, "고용주"), JOBSEEKER(2, "구직자")
	;
	private final int code;
	private final String korean;
	
}
