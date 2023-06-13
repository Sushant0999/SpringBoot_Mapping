package com.netsmartz.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartz.springsecurity.model.Student;
import com.netsmartz.springsecurity.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student insert(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	public Student getCourse(int id) {
		return studentRepository.findById(id).get();
	}

}
