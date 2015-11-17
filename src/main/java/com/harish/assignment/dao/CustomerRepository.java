package com.harish.assignment.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harish.assignment.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	Customer findByUserName(String username);

}
