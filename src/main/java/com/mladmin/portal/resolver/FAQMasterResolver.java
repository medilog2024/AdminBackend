package com.mladmin.portal.resolver;

import com.mladmin.portal.entity.FAQMaster;
import com.mladmin.portal.dto.FAQMasterInput;
import com.mladmin.portal.service.FAQMasterService;
import graphql.com.google.common.base.Optional; // GraphQL Optional
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FAQMasterResolver {

	 @Autowired
	    private FAQMasterService faqService;

	    // Query: Get all FAQs
	    public List<FAQMaster> getAllFAQs() {
	        return faqService.getAllFAQs();
	    }

	    // Mutation: Create FAQ
	    public FAQMaster createFAQ(FAQMasterInput input) {
	        return faqService.createFAQ(input);
	    }

	    // Mutation: Update FAQ
	    public FAQMaster updateFAQ(int id, FAQMasterInput input) {
	        return faqService.updateFAQ(id, input);
	    }

	    // Mutation: Delete FAQ
	    public boolean deleteFAQ(int id) {
	        return faqService.deleteFAQ(id);
	    }
}
