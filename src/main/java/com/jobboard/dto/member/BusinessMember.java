package com.jobboard.dto.member;

import com.jobboard.dto.enums.CompanyType;

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

    public void applyCompanyType(String type){
        this.companyType = CompanyType.valueOf(type.toUpperCase());
    }
}
