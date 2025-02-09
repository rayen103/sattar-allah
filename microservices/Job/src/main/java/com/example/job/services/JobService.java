package com.example.job.services;

import com.example.job.jobRepo.JobRepo;
import com.example.job.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    public Optional<Job> findById(int id) {
        return jobRepo.findById(id);
    }

    public Job save(Job job) {
        return jobRepo.save(job);
    }

    public Job update(int id, Job jobDetails) {
        return jobRepo.findById(id).map(job -> {
            job.setName(jobDetails.getName());
            job.setDescription(jobDetails.getDescription());
            job.setAvailable(jobDetails.isAvailable());
            job.setDate(jobDetails.getDate());
            return jobRepo.save(job);
        }).orElseThrow(() -> new RuntimeException("Job not found with id " + id));
    }

    public void delete(int id) {
        jobRepo.deleteById(id);
    }
}
