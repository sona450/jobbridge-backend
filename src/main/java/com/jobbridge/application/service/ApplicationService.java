package com.jobbridge.application.service;

import com.jobbridge.application.entity.ApplicationStatus;
import com.jobbridge.application.entity.JobApplication;
import com.jobbridge.application.repository.JobApplicationRepository;
import com.jobbridge.jobs.entity.Job;
import com.jobbridge.jobs.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationService {

    private final JobApplicationRepository repo;
    private final JobRepository jobRepo;

    public ApplicationService(JobApplicationRepository repo,
                              JobRepository jobRepo) {
        this.repo = repo;
        this.jobRepo = jobRepo;
    }

    public JobApplication apply(Long jobId, String email) {

        repo.findByApplicantEmailAndJobId(email, jobId)
                .ifPresent(a -> {
                    throw new RuntimeException("Already applied");
                });

        Job job = jobRepo.findById(jobId)
                .orElseThrow(() ->
                        new RuntimeException("Job not found"));

        JobApplication app = new JobApplication();
        app.setApplicantEmail(email);
        app.setJob(job);
        app.setStatus(ApplicationStatus.APPLIED);
        app.setAppliedAt(LocalDateTime.now());

        return repo.save(app);
    }
    public JobApplication updateStatus(Long id, String status) {

        JobApplication app = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        app.setStatus(ApplicationStatus.valueOf(status));

        return repo.save(app);
    }

    public List<JobApplication> myApplications(String email) {
        return repo.findByApplicantEmail(email);
    }

    public List<JobApplication> applicants(Long jobId) {
        return repo.findByJobId(jobId);
    }
}