package com.netsmartz.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netsmartz.springsecurity.model.Course;
import com.netsmartz.springsecurity.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/insert")
	public Course insertCourse(@RequestBody Course course) {
		return courseService.insert(course);
	}

	@GetMapping("/getAll")
	public List<Course> getAll() {
		return courseService.getAll();
	}
	
	@GetMapping("/get/{id}")
    public Course getCourse(@PathVariable int id) {
        return courseService.getCourse(id);
    }
}
