package com.mladmin.portal.service;

import com.mladmin.portal.dto.HospitalMasterInput;
import com.mladmin.portal.entity.HospitalMaster;
import com.mladmin.portal.repository.HospitalMasterRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List; 

@Service
public class HospitalMasterService {

    @Autowired
    private HospitalMasterRepository hospitalMasterRepository;

    // Method to create a new HospitalMaster
    public HospitalMaster createHospital(HospitalMasterInput input) {
        if (input.getName() == null || input.getName().isEmpty()) {
            throw new IllegalArgumentException("Hospital name must not be null or empty");
        }

        // Check if a Hospital with the same name already exists
        HospitalMaster existingHospital = hospitalMasterRepository.findByName(input.getName());
        if (existingHospital != null) {
            throw new RuntimeException("Hospital with this name already exists");
        }

        // Create and save the new Hospital
        HospitalMaster hospital = new HospitalMaster();
        hospital.setName(input.getName());
        hospital.setLocation(input.getLocation());
        hospital.setContactNumber(input.getContactNumber());
        hospital.setEmail(input.getEmail());

        try {
            // Attempt to save the Hospital
            HospitalMaster savedHospital = hospitalMasterRepository.save(hospital);

            // Return the saved Hospital, ensuring it's not null
            if (savedHospital == null) {
                throw new RuntimeException("Failed to create Hospital");
            }

            return savedHospital; // Return the valid, non-null Hospital
        } catch (Exception e) {
            // Handle any errors that occur during the saving process
            throw new RuntimeException("Error creating Hospital: " + e.getMessage());
        }
    }

    // Method to get all HospitalMaster records
    public List<HospitalMaster> getAllHospitals() {
        return hospitalMasterRepository.findAll();
    }

    // Method to get a HospitalMaster by ID
    public HospitalMaster getHospitalById(Long id) {
        return hospitalMasterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));
    }

    // Method to update an existing HospitalMaster
    public HospitalMaster updateHospital(Long id, HospitalMasterInput input) {
        HospitalMaster existingHospital = getHospitalById(id);

        existingHospital.setName(input.getName());
        existingHospital.setLocation(input.getLocation());
        existingHospital.setContactNumber(input.getContactNumber());
        existingHospital.setEmail(input.getEmail());

        return hospitalMasterRepository.save(existingHospital);
    }

    // Method to delete a HospitalMaster by ID
    public Boolean deleteHospital(Long id) {
        if (hospitalMasterRepository.existsById(id)) {
            hospitalMasterRepository.deleteById(id);
            return true;
        }
        return false;
    }
}