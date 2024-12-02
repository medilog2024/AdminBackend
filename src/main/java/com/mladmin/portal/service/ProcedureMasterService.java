package com.mladmin.portal.service;

import com.mladmin.portal.dto.ProcedureMasterInput;
import com.mladmin.portal.entity.ProcedureMaster;
import com.mladmin.portal.repository.ProcedureMasterRepository;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List; 
 
@Service
public class ProcedureMasterService {

	 @Autowired
	    private ProcedureMasterRepository procedureRepository;

	    // Get all Procedures
	    public List<ProcedureMaster> getAllProcedures() {
	        return procedureRepository.findAll();
	    } 

	    // Get a Procedure by ID
	    public ProcedureMaster getProcedureById(int id) {
	        return procedureRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Procedure not found"));
	    }
	    
	    // Create a new Procedure
	    public ProcedureMaster createProcedure(ProcedureMasterInput input) {
	    	ProcedureMaster procedure = new ProcedureMaster();
	    	procedure.setName(input.getName());
	    	procedure.setDescription(input.getDescription());
	        return procedureRepository.save(procedure);
	    }

	    // Update an existing Procedure
	    public ProcedureMaster updateProcedure(int id, ProcedureMasterInput input) {
	        return procedureRepository.findById(id)
	                .map(existingProcedure -> {
	                    existingProcedure.setName(input.getName());
	                    existingProcedure.setDescription(input.getDescription());
	                    return procedureRepository.save(existingProcedure); // Corrected this line
	                })
	                .orElseThrow(() -> new RuntimeException("Procedure not found with ID: " + id));
	    }

	    // Delete a Procedure
	    public boolean deleteProcedure(int id) {
	        if (procedureRepository.existsById(id)) {
	        	procedureRepository.deleteById(id);
	            return true; // Successfully deleted
	        }
	        return false; // Procedure not found
	    }
}
