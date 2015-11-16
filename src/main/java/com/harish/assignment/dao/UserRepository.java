package com.harish.assignment.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harish.assignment.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
