package com.jobbridge.jobs.controller;

import com.jobbridge.jobs.dto.JobRequest;
import com.jobbridge.jobs.entity.Job;
import com.jobbridge.jobs.service.JobService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @PostMapping
    public Job create(@RequestBody JobRequest req,
                      Authentication auth) {
        return service.create(req, auth.getName());
    }

    @GetMapping
    public List<Job> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Job getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Job deleted";
    }
}