package com.netsmartz.oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netsmartz.oneToMany.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
