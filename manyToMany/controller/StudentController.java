package com.netsmartz.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netsmartz.springsecurity.model.Student;
import com.netsmartz.springsecurity.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/insert")
	public Student insertStudent(@RequestBody Student student) {
		return studentService.insert(student);
	}

	@GetMapping("/getAll")
	public List<Student> getAll() {
		return studentService.getAll();
	}
	
	@GetMapping("/get/{id}")
    public Student getCourse(@PathVariable Integer id) {
        return studentService.getCourse(id);
    }

}
