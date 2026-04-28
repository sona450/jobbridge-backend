package com.jobbridge.jobs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "jobs")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String companyName;
    private String location;
    private String employmentType; // Full-time

    @Column(length = 2000)
    private String description;

    private String skillsRequired;
    private Integer experienceRequired;
    private Double salaryMin;
    private Double salaryMax;

    private String postedBy; // email
}