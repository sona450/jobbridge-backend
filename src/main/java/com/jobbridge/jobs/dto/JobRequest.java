package com.jobbridge.jobs.dto;

import lombok.Data;

@Data
public class JobRequest {

    private String title;
    private String companyName;
    private String location;
    private String employmentType;
    private String description;
    private String skillsRequired;
    private Integer experienceRequired;
    private Double salaryMin;
    private Double salaryMax;
}