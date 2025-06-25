package com.selefPractice.repository;

import com.selefPractice.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {


    Optional<Customer> findByUserName (String userName);


}
