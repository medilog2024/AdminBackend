package com.mladmin.portal.service;

import com.mladmin.portal.dto.FAQMasterInput;
import com.mladmin.portal.entity.FAQMaster;
 import com.mladmin.portal.repository.FAQMasterRepository;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import java.util.List; 
 
@Service
public class FAQMasterService {

	@Autowired
	private FAQMasterRepository faqRepository;
	
	public List<FAQMaster> getAllFAQs() {
	    return faqRepository.findAll();
	}
	
	public FAQMaster createFAQ(FAQMasterInput input) {
		FAQMaster faq = new FAQMaster();
	    faq.setQuestion(input.getQuestion());
	    faq.setAnswer(input.getAnswer());
	    return faqRepository.save(faq);
	}
	
	public FAQMaster updateFAQ(int id, FAQMasterInput input) {
		FAQMaster existingFAQ = faqRepository.findById(id).orElseThrow(() -> new RuntimeException("FAQ not found"));
	    existingFAQ.setQuestion(input.getQuestion());
	    existingFAQ.setAnswer(input.getAnswer());
	    return faqRepository.save(existingFAQ);
	}
	
	public boolean deleteFAQ(int id) {
		FAQMaster faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException("FAQ not found"));
	    faqRepository.delete(faq);
	    return true;
	}
}
