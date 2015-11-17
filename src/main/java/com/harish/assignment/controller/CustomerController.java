package com.harish.assignment.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harish.assignment.dao.AccountRepository;
import com.harish.assignment.dao.CustomerRepository;
import com.harish.assignment.model.Account;
import com.harish.assignment.model.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository userRepo;
	
	@Autowired
	AccountRepository accountRepo;

	@RequestMapping("/user")
	@RolesAllowed("ROLE_USER")
	public Customer isLoggedIn() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepo.findByUserName(userDetails.getUsername());
	}
	
	@RequestMapping("/accounts")
	@RolesAllowed("ROLE_USER")
	public List<Account> allAccounts() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = userRepo.findByUserName(userDetails.getUsername());
		return accountRepo.findAllByOperatedBy(customer);
	}

}
