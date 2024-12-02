package com.mladmin.portal.resolver;

import com.mladmin.portal.entity.ProcedureMaster;
import com.mladmin.portal.dto.ProcedureMasterInput;
import com.mladmin.portal.service.ProcedureMasterService;
import graphql.com.google.common.base.Optional; // GraphQL Optional
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProcedureMasterResolver {

    @Autowired
    private ProcedureMasterService procedureMasterService;
 
    // Query: Get all Procedures
    @QueryMapping
    public List<ProcedureMaster> getAllProcedures() {
        return procedureMasterService.getAllProcedures();
    }

    // Query: Get Procedure by ID
    @QueryMapping
    public ProcedureMaster getProcedureById(@Argument int id) {
        return procedureMasterService.getProcedureById(id);
    }

    // Mutation: Create a new Procedure
    @MutationMapping
    public ProcedureMaster createProcedure(@Argument ProcedureMasterInput input) {
        return procedureMasterService.createProcedure(input);
    }

    // Mutation: Update an existing Procedure
    @MutationMapping
    public ProcedureMaster updateProcedure(@Argument int id, @Argument ProcedureMasterInput input) {
        return procedureMasterService.updateProcedure(id, input);
    }

    // Mutation: Delete a Procedure
    @MutationMapping
    public boolean deleteProcedure(@Argument int id) {
        return procedureMasterService.deleteProcedure(id);
    }
}
