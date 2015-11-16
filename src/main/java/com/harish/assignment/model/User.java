package com.harish.assignment.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class User {
	@Id
	private Long customerId;
	
	private String name;
	
	private Date joinedOn;
	
	private Date lastLoggedIn;
	
	@OneToMany(targetEntity=Account.class, mappedBy="accountId", fetch=FetchType.EAGER)
	private List<Account> accounts;

}