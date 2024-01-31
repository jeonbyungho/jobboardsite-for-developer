package com.jobboard.auth.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BusinessMember {
    private Member member;
    private CompanyType companyType;
    private String companyName;
    private String ceo;
}
