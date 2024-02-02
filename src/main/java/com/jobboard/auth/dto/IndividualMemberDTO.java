package com.jobboard.auth.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class IndividualMemberDTO {
    private MemberDTO member;
    private String name;
    private String phone;
}
