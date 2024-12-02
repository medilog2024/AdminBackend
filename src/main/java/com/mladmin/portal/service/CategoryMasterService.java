package com.mladmin.portal.service;

import com.mladmin.portal.dto.CategoryMasterInput;
import com.mladmin.portal.entity.CategoryMaster;
import com.mladmin.portal.entity.HospitalMaster;
import com.mladmin.portal.repository.CategoryMasterRepository;

import graphql.com.google.common.base.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List; 
 
@Service
public class CategoryMasterService {

	 @Autowired
	    private CategoryMasterRepository categoryRepository;

	    // Get all categories
	    public List<CategoryMaster> getAllCategories() {
	        return categoryRepository.findAll();
	    } 

	    // Get a category by ID
	    public CategoryMaster getCategoryById(int id) {
	        return categoryRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Category not found"));
	    }
	    
	    // Create a new category
	    public CategoryMaster createCategory(CategoryMasterInput input) {
	        CategoryMaster category = new CategoryMaster();
	        category.setCategoryName(input.getCategoryName());
	        return categoryRepository.save(category);
	    }

	    // Update an existing category
	    public CategoryMaster updateCategory(int id, CategoryMasterInput input) {
	        return categoryRepository.findById(id)
	                .map(existingCategory -> {
	                    existingCategory.setCategoryName(input.getCategoryName());
	                    return categoryRepository.save(existingCategory);
	                })
	                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
	    }

	    // Delete a category
	    public boolean deleteCategory(int id) {
	        if (categoryRepository.existsById(id)) {
	            categoryRepository.deleteById(id);
	            return true; // Successfully deleted
	        }
	        return false; // Category not found
	    }
}
