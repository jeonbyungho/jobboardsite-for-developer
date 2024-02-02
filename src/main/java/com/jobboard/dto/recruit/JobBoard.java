package com.jobboard.dto.recruit;

import java.util.Set;
import java.time.LocalDateTime;

import com.jobboard.dto.Address;
import com.jobboard.dto.enums.JobTitle;
import com.jobboard.dto.member.BusinessMember;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class JobBoard {
    private Long id;
    private String title;
    private String content;

    private BusinessMember employer;
    private Address jobAddress;

    private Set<JobTitle> jobTitles;
    private Set<String> skills;

    private Set<String> jobTypes;
    private Set<String> careers;
    
    private int minSalary, maxSalary;
    private LocalDateTime startRecruitPeriod, endRecruitPeriod;
    private LocalDateTime createdAt, modifiedAt;
}
