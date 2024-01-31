package com.jobboard.auth.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BusinessMember {
    private Member member;
    private CompanyType companyType;
    private int bizRegistrationNo;
    private String companyName;
    private String ceoName;

    public void setCompanyType(String type){
        this.companyType = CompanyType.valueOf(type.toUpperCase());
    }
}
