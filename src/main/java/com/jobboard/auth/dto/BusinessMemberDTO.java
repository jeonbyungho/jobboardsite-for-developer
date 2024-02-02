package com.jobboard.auth.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BusinessMemberDTO {
    private MemberDTO member;
    private CompanyType companyType;
    private int bizRegistrationNo;
    private String companyName;
    private String ceoName;

    public void applyCompanyType(String type){
        this.companyType = CompanyType.valueOf(type.toUpperCase());
    }
}
