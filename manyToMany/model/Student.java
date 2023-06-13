package com.netsmartz.springsecurity.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIdentityInfo(generator = PropertyGenerator.class, property = "id")
	private int id;

	@NonNull
	@Size(min = 4)
	private String name;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, @NonNull @Size(min = 4) String name, @Email String email, List<Course> courseList) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.courseList = courseList;
	}

	@Email
	private String email;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "enroll", joinColumns = @JoinColumn(name = "fk_student_id"), inverseJoinColumns = @JoinColumn(name = "fk_course_id"))
	@JsonManagedReference
	private List<Course> courseList;

	public int getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
}
