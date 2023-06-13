package com.netsmartz.oneToMany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartz.oneToMany.model.Employee;
import com.netsmartz.oneToMany.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee insert(Employee emp) {
		return employeeRepository.save(emp);
	}

	public List<Employee> getAllemp() {
		List<Employee> allEmp = (List<Employee>) employeeRepository.findAll();
		return allEmp;
	}

	public Optional<Employee> getEmployee(Integer id) {
		return employeeRepository.findById(id);
	}

	public Employee update(Integer id, Employee emp) {
		emp.setId(id);
		return employeeRepository.save(emp);
	}

	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}
}
