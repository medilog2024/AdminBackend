package com.mladmin.portal.mutations;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

import com.mladmin.portal.dto.UserMasterInput;
import com.mladmin.portal.entity.UserMaster;
import com.mladmin.portal.service.UserMasterService;

@Component
public class UsersMasterMutation {

    @Autowired
    private UserMasterService userMasterService;

    // Create a new UserMaster
    @MutationMapping
    public UserMaster createUser(@Argument UserMasterInput input) {
        return userMasterService.createUser(input);
    }
 
}
