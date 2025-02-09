package com.example.job.services;

import com.example.job.entities.Category;
import com.example.job.services.CategoryService;
import com.example.job.jobRepo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Optional<Category> findById(int id) {
        return categoryRepo.findById(id);
    }

    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    public Category update(int id, Category categoryDetails) {
        return categoryRepo.findById(id).map(category -> {
            category.setName(categoryDetails.getName());
            category.setDescription(categoryDetails.getDescription());
            return categoryRepo.save(category);
        }).orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    }

    public void delete(int id) {
        categoryRepo.deleteById(id);
    }
}
