package com.mladmin.portal.service;

import com.mladmin.portal.dto.ContactUsMasterInput;
import com.mladmin.portal.entity.ContactUsMaster;
 import com.mladmin.portal.repository.ContactUsMasterRepository;

import graphql.com.google.common.base.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List; 
 
@Service
public class ContactUsMasterService {

	@Autowired
    private ContactUsMasterRepository contactUsRepository;

    public ContactUsMaster createContactUs(ContactUsMasterInput input) {
    	ContactUsMaster message = new ContactUsMaster();
        message.setName(input.getName());
        message.setEmail(input.getEmail());
        message.setMessage(input.getMessage());
        return contactUsRepository.save(message);
    }
}
