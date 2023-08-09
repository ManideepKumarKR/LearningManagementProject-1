package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO ) 
	int id;
	@Column(name="course_name")
	String courseName;
	@Column(name="course_price")
	int coursePrice;
	@OneToMany
	List<Lesson> lesson;
	
	@ManyToMany
	List<Users>userList;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName, int coursePrice, List<Lesson> lesson, List<Users> userList) {
		super();
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.lesson = lesson;
		this.userList=userList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public List<Lesson> getLesson() {
		return lesson;
	}

	public void setLesson(List<Lesson> lesson) {
		this.lesson = lesson;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", coursePrice=" + coursePrice + "]";
	}

	
	
}














