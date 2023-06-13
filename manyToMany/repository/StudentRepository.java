package com.netsmartz.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netsmartz.springsecurity.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
