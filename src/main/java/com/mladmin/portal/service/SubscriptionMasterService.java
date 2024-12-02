package com.mladmin.portal.service;

 import com.mladmin.portal.dto.SubscriptionMasterInput;
import com.mladmin.portal.entity.SubscriptionMaster;
 import com.mladmin.portal.repository.SubscriptionMasterRepository;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List; 
 
@Service
public class SubscriptionMasterService {

	 @Autowired
	    private SubscriptionMasterRepository subscriptionRepository;

	    public List<SubscriptionMaster> getAllSubscriptions() {
	        return subscriptionRepository.findAll();
	    }

	    public SubscriptionMaster getSubscriptionById(int id) {
	    	 return subscriptionRepository.findById(id)
		                .orElseThrow(() -> new RuntimeException("Subscription not found"));
	    }

	    public SubscriptionMaster createSubscription(SubscriptionMasterInput input) {
	        SubscriptionMaster subscription = new SubscriptionMaster();
	        subscription.setPlanName(input.getPlanName());
	        subscription.setDescription(input.getDescription());
	        subscription.setPrice(input.getPrice());
	        subscription.setDuration(input.getDuration());
	        subscription.setCreatedAt("current_timestamp");
	        subscription.setUpdatedAt("current_timestamp");
	        return subscriptionRepository.save(subscription);
	    }

	    public SubscriptionMaster updateSubscription(int id, SubscriptionMasterInput input) {
	        // Find the existing subscription by id
	        return subscriptionRepository.findById(id)
	            .map(existingSubscription -> {
	                // Set updated values
	                existingSubscription.setPlanName(input.getPlanName());
	                existingSubscription.setDescription(input.getDescription());
	                existingSubscription.setPrice(input.getPrice());
	                existingSubscription.setDuration(input.getDuration());
	                existingSubscription.setUpdatedAt("current_timestamp");  // You can set the current timestamp here, or use a real timestamp.
	                
	                // Save and return the updated subscription
	                return subscriptionRepository.save(existingSubscription);
	            })
	            .orElseThrow(() -> new RuntimeException("Subscription not found with ID: " + id));  // Handle if subscription is not found
	    }


	    public boolean deleteSubscription(int id) {
	        if (subscriptionRepository.existsById(id)) {
	            subscriptionRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}
