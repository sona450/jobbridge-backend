package com.jobbridge.user.dto;

import lombok.Data;

@Data
public class ProfileUpdateRequest {

    private String name;
    private String phone;
    private String location;
    private String skills;
    private Integer experienceYears;
    private String bio;
}