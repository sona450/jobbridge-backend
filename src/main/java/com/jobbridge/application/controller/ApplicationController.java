package com.jobbridge.application.controller;

import com.jobbridge.application.entity.JobApplication;
import com.jobbridge.application.service.ApplicationService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @PostMapping("/{jobId}")
    public JobApplication apply(@PathVariable Long jobId,
                                Authentication auth) {
        return service.apply(jobId, auth.getName());
    }

    @GetMapping("/my")
    public List<JobApplication> my(Authentication auth) {
        return service.myApplications(auth.getName());
    }

    @GetMapping("/job/{jobId}")
    public List<JobApplication> applicants(
            @PathVariable Long jobId) {
        return service.applicants(jobId);
    }

    @PutMapping("/{id}/status")
    public JobApplication updateStatus(@PathVariable Long id,
                                       @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}