package com.mladmin.portal.resolver;

import com.mladmin.portal.entity.ContactUsMaster;
import com.mladmin.portal.dto.ContactUsMasterInput;
import com.mladmin.portal.service.ContactUsMasterService;
import graphql.com.google.common.base.Optional; // GraphQL Optional
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ContactUsMasterResolver {

	@Autowired
    private ContactUsMasterService contactUsService;

    // Mutation: Create Contact Us message
    public ContactUsMaster createContactUsMessage(ContactUsMasterInput input) {
        return contactUsService.createContactUs(input);
    }
}
