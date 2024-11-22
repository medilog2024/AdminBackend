package com.mladmin.portal.resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.mladmin.portal.dto.UserMasterInput;
import com.mladmin.portal.entity.UserMaster;
import com.mladmin.portal.service.UserMasterService;

@Controller
public class UserMasterResolver {

    private final UserMasterService userMasterService;

    public UserMasterResolver(UserMasterService userMasterService) {
        this.userMasterService = userMasterService;
    } 

    // Query: Get a user by ID
    @QueryMapping
    public UserMaster findUserById(@Argument String email) {
        return userMasterService.findUserByEmail(email);
    }

    // Mutation: Create a new user
    @MutationMapping
    public UserMaster createUser(@Argument UserMasterInput input) {
        return userMasterService.createUser(input);
    }
 
}
