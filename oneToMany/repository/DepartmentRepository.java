package com.netsmartz.oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netsmartz.oneToMany.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
