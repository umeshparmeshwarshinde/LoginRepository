package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public User saveUser(User user) {
		return registrationRepository.save(user);
		
	}
	
	public User fetchByEmailId(String emailId) {
		return registrationRepository.findByEmailId(emailId);
	}
	
	public User fetchByEmailIdAndPassword(String emailId,String password) {
		return registrationRepository.findByEmailIdAndPassword(emailId, password);
	}
}
