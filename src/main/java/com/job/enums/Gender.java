package com.job.enums;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public enum Gender {
	MALE("남자"), FEMALE("여자");
	private String korean;
	Gender(String korean) {
		this.korean = korean;
	}
}
