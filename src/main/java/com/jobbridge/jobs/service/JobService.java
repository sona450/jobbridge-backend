package com.jobbridge.jobs.service;

import com.jobbridge.jobs.dto.JobRequest;
import com.jobbridge.jobs.entity.Job;
import com.jobbridge.jobs.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository repo;

    public JobService(JobRepository repo) {
        this.repo = repo;
    }

    public Job create(JobRequest req, String email) {
        Job job = new Job();

        job.setTitle(req.getTitle());
        job.setCompanyName(req.getCompanyName());
        job.setLocation(req.getLocation());
        job.setEmploymentType(req.getEmploymentType());
        job.setDescription(req.getDescription());
        job.setSkillsRequired(req.getSkillsRequired());
        job.setExperienceRequired(req.getExperienceRequired());
        job.setSalaryMin(req.getSalaryMin());
        job.setSalaryMax(req.getSalaryMax());
        job.setPostedBy(email);

        return repo.save(job);
    }

    public List<Job> getAll() {
        return repo.findAll();
    }

    public Job getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}