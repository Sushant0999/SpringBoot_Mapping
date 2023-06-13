package com.netsmartz.oneToMany.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netsmartz.oneToMany.model.Employee;
import com.netsmartz.oneToMany.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/insertEmp")
	public Employee insertEmp(@Valid @RequestBody Employee emp) {
		System.out.println(emp);
		Employee emp1 = employeeService.insert(emp);
		return emp1;
	}

	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmp() {
		List<Employee> emp1 = (List<Employee>) employeeService.getAllemp();
		return emp1;
	}

	@GetMapping("/getId/{id}")
	public Optional<Employee> getById(@PathVariable Integer id) {
		return employeeService.getEmployee(id);
	}

	@PutMapping("/update/{id}")
	public Employee updateById(@PathVariable("id") Integer id, @Valid @RequestBody Employee emp) {
		return employeeService.update(id, emp);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Integer id) {
		employeeService.delete(id);
		return "DONE";
	}
}
