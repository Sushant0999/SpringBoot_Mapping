package com.netsmartz.springsecurity.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.NonNull;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private int id;

	@NonNull
	private String name;

	@ManyToMany(mappedBy = "courseList", fetch = FetchType.LAZY)
	private List<Student> studentList;

	public int getId() {
		return id;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id, @NonNull String name, List<Student> studentList) {
		super();
		this.id = id;
		this.name = name;
		this.studentList = studentList;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}
