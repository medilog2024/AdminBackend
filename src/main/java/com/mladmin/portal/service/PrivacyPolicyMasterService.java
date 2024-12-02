package com.mladmin.portal.service;

import com.mladmin.portal.dto.PrivacyPolicyMasterInput;
import com.mladmin.portal.entity.PrivacyPolicyMaster;
 import com.mladmin.portal.repository.PrivacyPolicyMasterRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  
 
@Service
public class PrivacyPolicyMasterService {

	 @Autowired
	    private PrivacyPolicyMasterRepository privacyPolicyRepository;

	    public PrivacyPolicyMaster getPrivacyPolicy(int id) {
	        return privacyPolicyRepository.findById(id).orElseThrow(() -> new RuntimeException("Privacy Policy not found"));
	    }

	    public PrivacyPolicyMaster createPrivacyPolicy(PrivacyPolicyMasterInput input) {
	    	PrivacyPolicyMaster policy = new PrivacyPolicyMaster();
	        policy.setTitle(input.getTitle());
	        policy.setContent(input.getContent());
	        return privacyPolicyRepository.save(policy);
	    }

	    public PrivacyPolicyMaster updatePrivacyPolicy(int id, PrivacyPolicyMasterInput input) {
	    	PrivacyPolicyMaster existingPolicy = getPrivacyPolicy(id);
	        existingPolicy.setTitle(input.getTitle());
	        existingPolicy.setContent(input.getContent());
	        return privacyPolicyRepository.save(existingPolicy);
	    }
}
