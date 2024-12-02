package com.mladmin.portal.mutations;

import com.mladmin.portal.dto.CategoryMasterInput;
import com.mladmin.portal.entity.CategoryMaster;
import com.mladmin.portal.service.CategoryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
public class CatgegoryMasterMutation {

    @Autowired
    private CategoryMasterService categoryMasterService;
    
    // Mutation: Create a new category
    @MutationMapping
    public CategoryMaster createCategory(@Argument CategoryMasterInput input) {
    	System.out.println("Creating Category: " + input.getCategoryName()); 
        return categoryMasterService.createCategory(input);
    }

    // Mutation: Update an existing category
    @MutationMapping
    public CategoryMaster updateCategory(@Argument int id, CategoryMasterInput input) {
        return categoryMasterService.updateCategory(id, input);
    }
  

    // Mutation: Delete a category
    @MutationMapping
    public String deleteCategory(@Argument int id) {
        categoryMasterService.deleteCategory(id);
        return "Category deleted successfully.";
    } 
}
