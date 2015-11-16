package com.harish.assignment.model;

import java.util.Currency;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="accounts")
@Data
public class Account {
	
	@Id
	private Long accountId;
	
	private Double balance;
	
	private Currency unit;
	
	private Date createdOn;

}
