package com.jobboard.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum CompanyType {
    LARGE("대기업"), MID("중견기업"), SMALL("중소기업"), ETC("기타");
    private String kor;
}