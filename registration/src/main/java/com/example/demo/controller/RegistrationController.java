package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.RegistrationService;

@CrossOrigin(origins = {"http://localhost:4200","*"})
@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj = service.fetchByEmailId(tempEmailId);
			if (userobj != null) {
				throw new Exception("user with " + tempEmailId + " id already exist!");
			}
		}
		return service.saveUser(user);
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String emailId = user.getEmailId();
		String password = user.getPassword();
		User userObj=null;
		if(emailId!=null && password!=null) {
			userObj = service.fetchByEmailIdAndPassword(emailId, password);
			
		}
		if(userObj ==null) {
			throw new Exception("Bad Creadational");
		}
		return userObj;
	}

}
