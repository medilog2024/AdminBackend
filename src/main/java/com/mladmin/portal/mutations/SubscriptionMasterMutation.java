package com.mladmin.portal.mutations;

import com.mladmin.portal.dto.SubscriptionMasterInput;
import com.mladmin.portal.entity.SubscriptionMaster;
import com.mladmin.portal.service.SubscriptionMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMasterMutation {

    @Autowired
    private SubscriptionMasterService subscriptionMasterService;
    
    // Mutation: Create a new Subscription
    @MutationMapping
    public SubscriptionMaster createSubscription(@Argument SubscriptionMasterInput input) {
    	System.out.println("Creating Subscription: " + input.getPlanName()); 
        return subscriptionMasterService.createSubscription(input);
    }

    // Mutation: Update an existing Subscription
    @MutationMapping
    public SubscriptionMaster updateProcedure(@Argument int id, SubscriptionMasterInput input) {
        return subscriptionMasterService.updateSubscription(id, input);
    }
  

    // Mutation: Delete a Subscription
    @MutationMapping
    public String deleteProcedure(@Argument int id) {
    	subscriptionMasterService.deleteSubscription(id);
        return "Subscription deleted successfully.";
    } 
}
