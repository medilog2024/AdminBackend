package com.mladmin.portal.resolver;

import com.mladmin.portal.dto.HospitalMasterInput;
import com.mladmin.portal.entity.HospitalMaster;
import com.mladmin.portal.service.HospitalMasterService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor // Automatically injects final fields
public class HospitalMasterResolver {

	@Autowired
    private HospitalMasterService hospitalMasterService;


    // Query to get all hospitals
    @QueryMapping
    public List<HospitalMaster> getAllHospitals() {
        return hospitalMasterService.getAllHospitals();
    }

    // Query to get a hospital by ID
    @QueryMapping
    public HospitalMaster getHospitalById(@Argument Long id) {
        return hospitalMasterService.getHospitalById(id);
    }

    // Mutation to create a new hospital
    @MutationMapping
    public HospitalMaster createHospital(@Argument HospitalMasterInput input) {
        return hospitalMasterService.createHospital(input);
    }

    // Mutation to update an existing hospital
    @MutationMapping
    public HospitalMaster updateHospital(@Argument Long id, @Argument HospitalMasterInput input) {
        return hospitalMasterService.updateHospital(id, input);
    }

    // Mutation to delete an existing hospital by ID
    @MutationMapping
    public Boolean deleteHospital(@Argument Long id) {
        return hospitalMasterService.deleteHospital(id);
    }
}
