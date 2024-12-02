package com.mladmin.portal.mutations;

import com.mladmin.portal.dto.ContactUsMasterInput;
import com.mladmin.portal.entity.ContactUsMaster;
import com.mladmin.portal.service.ContactUsMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
public class ContactUsMasterMutation {

    @Autowired
    private ContactUsMasterService contactUsMasterService;
    
    // Mutation: Create a new category
    @MutationMapping
    public ContactUsMaster createContactUs(@Argument ContactUsMasterInput input) {
    	System.out.println("Creating Category: " + input.getName()); 
        return contactUsMasterService.createContactUs(input);
    }

    
  
 
}
