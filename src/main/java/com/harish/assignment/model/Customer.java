package com.harish.assignment.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {
	@Id
	private Long customerId;
	
	@JoinColumn(table="users",referencedColumnName="username")
	private String userName;
	
	private String name;
	
	private Date joinedOn;
	
	private Date lastLoggedIn;
	
	@OneToMany
	private Set<Account> accounts;

}