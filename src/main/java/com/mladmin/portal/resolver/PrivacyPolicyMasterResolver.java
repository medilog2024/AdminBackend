package com.mladmin.portal.resolver;

import com.mladmin.portal.entity.PrivacyPolicyMaster;
import com.mladmin.portal.dto.PrivacyPolicyMasterInput;
import com.mladmin.portal.service.PrivacyPolicyMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
 

@Controller
public class PrivacyPolicyMasterResolver {

	   @Autowired
	    private PrivacyPolicyMasterService privacyPolicyService;

	    // Query: Get Privacy Policy by ID
	    public PrivacyPolicyMaster getPrivacyPolicy(@Argument int id) {
	        return privacyPolicyService.getPrivacyPolicy(id);
	    }

	    @MutationMapping
	    public PrivacyPolicyMaster createPrivacyPolicy(@Argument PrivacyPolicyMasterInput input) {
	        System.out.println("Creating Privacy Policy: " + input.getTitle());
	        return privacyPolicyService.createPrivacyPolicy(input);
	    }

	    @MutationMapping
	    public PrivacyPolicyMaster updatePrivacyPolicy(@Argument int id, PrivacyPolicyMasterInput input) {
	        return privacyPolicyService.updatePrivacyPolicy(id, input);
	    }
}
