package com.mladmin.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mladmin.portal.dto.UserMasterInput;
import com.mladmin.portal.entity.UserMaster;
import com.mladmin.portal.repository.UserMasterRepository;

import java.util.Optional;

@Service
public class UserMasterService {

    @Autowired
    private UserMasterRepository userMasterRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create UserMaster with only emailId and password
    public UserMaster createUser(UserMasterInput input) {
        
        // Check if the email already exists
        if (userMasterRepository.findByEmailId(input.getEmailId()).isPresent()) {
            // Return an error response if the email already exists
            UserMaster errorUser = new UserMaster();
            errorUser.setEmailId("Email already exists");
            return errorUser;
        }

        // Create and save the new UserMaster
        UserMaster userMaster = new UserMaster();
        userMaster.setEmailId(input.getEmailId());
        userMaster.setPassword(passwordEncoder.encode(input.getPassword()));  // Encrypt the password

        return userMasterRepository.save(userMaster);
    }

    // Get User by Email
    public UserMaster findUserByEmail(String email) {
        Optional<UserMaster> userMaster = userMasterRepository.findByEmailId(email);
        return userMaster.orElse(null);
    }

    // Update UserMaster with only emailId and password
    public UserMaster updateUser(String email, UserMasterInput input) {
        UserMaster userMaster = findUserByEmail(email);
        if (userMaster != null) {
            userMaster.setPassword(passwordEncoder.encode(input.getPassword())); // Update password
            return userMasterRepository.save(userMaster);
        }
        return null;
    }

    // Delete UserMaster by email
    public boolean deleteUser(String email) {
        UserMaster userMaster = findUserByEmail(email);
        if (userMaster != null) {
            userMasterRepository.delete(userMaster);
            return true;
        }
        return false;
    }
}
