package com.netsmartz.oneToMany.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netsmartz.oneToMany.model.Department;
import com.netsmartz.oneToMany.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/insertDept")
	public Department insertDept(@RequestBody Department dept) {
		Department dept1 = departmentService.insert(dept);
		return dept1;
	}

	@GetMapping("/getAllDept")
	public List<Department> getAllDept() {
		List<Department> dept = departmentService.getAllDept();
		return dept;
	}

	@GetMapping("/getId/{id}")
	public Optional<Department> getById(@PathVariable Integer id) {
		return departmentService.getDepartment(id);
	}

}
