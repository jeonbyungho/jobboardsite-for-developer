package com.jobboard.auth.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class IndividualMember {
    private Member member;
    private String name;
    private String phone;
}
