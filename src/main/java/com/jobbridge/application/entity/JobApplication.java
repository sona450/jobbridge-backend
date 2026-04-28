package com.jobbridge.application.entity;

import com.jobbridge.jobs.entity.Job;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Data
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantEmail;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private String status; // APPLIED, REVIEWED, REJECTED, HIRED

    private LocalDateTime appliedAt;
}