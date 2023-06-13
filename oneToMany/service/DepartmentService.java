package com.netsmartz.oneToMany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartz.oneToMany.model.Department;
import com.netsmartz.oneToMany.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department insert(Department dept) {
		return departmentRepository.save(dept);
	}

	public List<Department> getAllDept() {
		List<Department> dept = (List<Department>) departmentRepository.findAll();
		return dept;
	}
	
	public Optional<Department> getDepartment(Integer id) {
		return departmentRepository.findById(id);
	}

}
