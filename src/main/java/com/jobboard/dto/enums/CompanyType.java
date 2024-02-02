package com.jobboard.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum CompanyType {
    LARGE(1,"대기업"), MID(2,"중견기업"), SMALL(3,"중소기업"), ETC(0,"기타");
    private final int code;
    private final String kor;
}