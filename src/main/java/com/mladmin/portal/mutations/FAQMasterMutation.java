package com.mladmin.portal.mutations;

import com.mladmin.portal.dto.FAQMasterInput;
import com.mladmin.portal.entity.FAQMaster;
import com.mladmin.portal.service.FAQMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
public class FAQMasterMutation {

    @Autowired
    private FAQMasterService faqMasterService;
    
    // Mutation: Create a new category
    @MutationMapping
    public FAQMaster createFAQ(@Argument FAQMasterInput input) {
    	System.out.println("Creating Category: " + input.getQuestion()); 
        return faqMasterService.createFAQ(input);
    }

    // Mutation: Update an existing category
    @MutationMapping
    public FAQMaster updateFAQ(@Argument int id, FAQMasterInput input) {
        return faqMasterService.updateFAQ(id, input);
    }
  

    // Mutation: Delete a category
    @MutationMapping
    public String deleteCategory(@Argument int id) {
    	faqMasterService.deleteFAQ(id);
        return "FAQ deleted successfully.";
    } 
}
