package com.harish.assignment.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

	@RequestMapping("/ping")
	@RolesAllowed("ROLE_USER")
	public String isLoggedIn() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails.getUsername();
	}

}
