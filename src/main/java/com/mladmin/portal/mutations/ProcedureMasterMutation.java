package com.mladmin.portal.mutations;

import com.mladmin.portal.dto.ProcedureMasterInput;
import com.mladmin.portal.entity.ProcedureMaster;
import com.mladmin.portal.service.ProcedureMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
public class ProcedureMasterMutation {

    @Autowired
    private ProcedureMasterService procedureMasterService;
    
    // Mutation: Create a new Procedure
    @MutationMapping
    public ProcedureMaster createProcedure(@Argument ProcedureMasterInput input) {
    	System.out.println("Creating Procedure: " + input.getName()); 
        return procedureMasterService.createProcedure(input);
    }

    // Mutation: Update an existing Procedure
    @MutationMapping
    public ProcedureMaster updateProcedure(@Argument int id, ProcedureMasterInput input) {
        return procedureMasterService.updateProcedure(id, input);
    }
  

    // Mutation: Delete a Procedure
    @MutationMapping
    public String deleteProcedure(@Argument int id) {
    	procedureMasterService.deleteProcedure(id);
        return "Procedure deleted successfully.";
    } 
}
