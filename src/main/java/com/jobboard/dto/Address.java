package com.jobboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor
public class Address {
    private String zipcode;
    private String sido;
    private String sigungo;
    private String address;
    private String address_detail;
}
