package com.example.job.jobRepo;

import com.example.job.entities.Category;
import com.example.job.jobRepo.CategoryRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
