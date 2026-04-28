package com.jobbridge.jobs.repository;

import com.jobbridge.jobs.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}