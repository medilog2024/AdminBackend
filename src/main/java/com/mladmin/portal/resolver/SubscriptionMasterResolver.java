package com.mladmin.portal.resolver;

import com.mladmin.portal.entity.SubscriptionMaster;
import com.mladmin.portal.dto.SubscriptionMasterInput;
import com.mladmin.portal.service.SubscriptionMasterService;
import graphql.com.google.common.base.Optional; // GraphQL Optional
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SubscriptionMasterResolver {

	   @Autowired
	    private SubscriptionMasterService subscriptionService;

	    // Query: Get all Subscriptions
	    @QueryMapping
	    public List<SubscriptionMaster> getAllSubscriptions() {
	        return subscriptionService.getAllSubscriptions();
	    }

	    // Query: Get Subscription by ID
	    @QueryMapping
	    public SubscriptionMaster getSubscriptionById(@Argument int id) {
	        return subscriptionService.getSubscriptionById(id);
	    }

	    // Mutation: Create a new Subscription
	    @MutationMapping
	    public SubscriptionMaster createSubscription(@Argument SubscriptionMasterInput input) {
	        return subscriptionService.createSubscription(input);
	    }

	    // Mutation: Update an existing Subscription
	    @MutationMapping
	    public SubscriptionMaster updateSubscription(@Argument int id, @Argument SubscriptionMasterInput input) {
	        return subscriptionService.updateSubscription(id, input);
	    }

	    // Mutation: Delete a Subscription
	    @MutationMapping
	    public boolean deleteSubscription(@Argument int id) {
	        return subscriptionService.deleteSubscription(id);
	    }
}
