package com.mladmin.portal.mutations;

import com.mladmin.portal.dto.PrivacyPolicyMasterInput;
import com.mladmin.portal.entity.PrivacyPolicyMaster;
import com.mladmin.portal.service.PrivacyPolicyMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
public class PrivacyPolicyMasterMutation {

    @Autowired
    private PrivacyPolicyMasterService privacyPolicyMasterService;
    
    // Mutation: Create a new category
    @MutationMapping
    public PrivacyPolicyMaster createPrivacyPolicy(@Argument PrivacyPolicyMasterInput input) {
        System.out.println("Creating Privacy Policy: " + input.getTitle());
        return privacyPolicyMasterService.createPrivacyPolicy(input);
    }

    // Mutation: Update an existing category
    @MutationMapping
    public PrivacyPolicyMaster updatePrivacyPolicy(@Argument int id, PrivacyPolicyMasterInput input) {
        return privacyPolicyMasterService.updatePrivacyPolicy(id, input);
    }
   
}
