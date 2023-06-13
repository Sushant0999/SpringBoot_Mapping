package com.netsmartz.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartz.springsecurity.model.Course;
import com.netsmartz.springsecurity.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public Course insert(Course course) {
		return courseRepository.save(course);
	}

	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	public Course getCourse(int id) {
		return courseRepository.findById(id).get();
	}
}
