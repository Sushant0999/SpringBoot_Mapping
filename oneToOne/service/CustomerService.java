package com.netsmartz.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartz.springsecurity.model.Customer;
import com.netsmartz.springsecurity.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomer(int id) {
		Customer customer = null;
		try {
			customer = customerRepository.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return customer;
	}

	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}

	public Customer updateCustomer(int id, Customer customer) {
		Customer customer2 = customerRepository.findById(id).get();
		customer2.setName(customer.getName());
		customer2.setAddress(customer.getAddress());
		return customerRepository.save(customer2);
	}

	public List<Customer> getAll() {
		return customerRepository.findAll();
	}
}
