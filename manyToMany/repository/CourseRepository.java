package com.netsmartz.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netsmartz.springsecurity.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
