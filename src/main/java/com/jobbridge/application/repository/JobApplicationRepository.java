package com.jobbridge.application.repository;

import com.jobbridge.application.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByApplicantEmail(String email);

    List<JobApplication> findByJobId(Long jobId);

    Optional<JobApplication> findByApplicantEmailAndJobId(
            String email, Long jobId);
}