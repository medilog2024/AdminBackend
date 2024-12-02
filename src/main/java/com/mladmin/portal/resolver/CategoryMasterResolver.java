package com.mladmin.portal.resolver;

import com.mladmin.portal.entity.CategoryMaster;
import com.mladmin.portal.dto.CategoryMasterInput;
import com.mladmin.portal.service.CategoryMasterService;
import graphql.com.google.common.base.Optional; // GraphQL Optional
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryMasterResolver {

    @Autowired
    private CategoryMasterService categoryMasterService;
 
    // Query: Get all categories
    @QueryMapping
    public List<CategoryMaster> getAllCategories() {
        return categoryMasterService.getAllCategories();
    }

    // Query: Get category by ID
    @QueryMapping
    public CategoryMaster getCategoryById(@Argument int id) {
        return categoryMasterService.getCategoryById(id);
    }

    // Mutation: Create a new category
    @MutationMapping
    public CategoryMaster createCategory(@Argument CategoryMasterInput input) {
        return categoryMasterService.createCategory(input);
    }

    // Mutation: Update an existing category
    @MutationMapping
    public CategoryMaster updateCategory(@Argument int id, @Argument CategoryMasterInput input) {
        return categoryMasterService.updateCategory(id, input);
    }

    // Mutation: Delete a category
    @MutationMapping
    public boolean deleteCategory(@Argument int id) {
        return categoryMasterService.deleteCategory(id);
    }
}
