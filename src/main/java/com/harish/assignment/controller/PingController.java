package com.harish.assignment.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harish.assignment.dao.UserRepository;
import com.harish.assignment.model.User;

@RestController
public class PingController {
	
	UserRepository userRepo;

	@RequestMapping("/ping")
	@RolesAllowed("ROLE_USER")
	public User isLoggedIn() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepo.findOne(userDetails.getUsername());
	}

}
