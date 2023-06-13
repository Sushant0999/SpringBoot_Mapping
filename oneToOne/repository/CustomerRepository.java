package com.netsmartz.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netsmartz.springsecurity.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
