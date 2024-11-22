package com.mladmin.portal.mutations;

import com.mladmin.portal.dto.HospitalMasterInput;
import com.mladmin.portal.entity.HospitalMaster;
import com.mladmin.portal.service.HospitalMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
public class HospitalMasterMutation {

    @Autowired
    private HospitalMasterService hospitalMasterService;

    // Create a new HospitalMaster
    @MutationMapping
    public HospitalMaster createHospital(@Argument HospitalMasterInput input) {
        System.out.println("Creating Hospital: " + input.getName()); 
        return hospitalMasterService.createHospital(input);  // Calling the service layer
    }

    // Update an existing HospitalMaster
    @MutationMapping
    public HospitalMaster updateHospital(@Argument Long id, @Argument HospitalMasterInput input) {
        System.out.println("Updating Hospital with ID: " + id);
        return hospitalMasterService.updateHospital(id, input);
    }

    // Delete an existing HospitalMaster by ID
    @MutationMapping
    public Boolean deleteHospital(@Argument Long id) {
        System.out.println("Deleting Hospital with ID: " + id);
        return hospitalMasterService.deleteHospital(id);
    }
}
