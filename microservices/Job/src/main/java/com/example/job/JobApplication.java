package com.example.job;

import com.example.job.entities.Job;
import com.example.job.jobRepo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
@EnableDiscoveryClient
@SpringBootApplication
public class JobApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }
    @Autowired
    private JobRepo jobRepo;
    @Bean
    public ApplicationRunner init(){
        return (args)->{
            jobRepo.save(new Job("rayen", "test", true, LocalDate.of(2025, 2, 9)));
        };
    }

}
