package com.harish.assignment.model;

import java.util.Currency;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class Account {

	@Id
	private Long accountId;

	private Double balance;

	private Currency currencyUnit;

	private Date createdOn;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer operatedBy;
	
}
