package com.harish.assignment.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harish.assignment.model.Account;
import com.harish.assignment.model.Customer;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

	List<Account> findAllByOperatedBy(Customer customer);


}
