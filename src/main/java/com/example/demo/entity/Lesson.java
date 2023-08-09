package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="lesson")
public class Lesson {
	
	@Id
	@Column(name="lesson_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name="lessonName")
	String lessonName;
	@Column(name="topics")
	String topics;
	@Column(name="link")
	String link;
	
	@ManyToOne
	Course course;
	
	public Lesson() {
		// TODO Auto-generated constructor stub
	}

	public Lesson(String lessonName, String topics, String link, Course course) {
		super();
		this.lessonName = lessonName;
		this.topics = topics;
		this.link = link;
		this.course = course;
	}

	

	public Lesson(int id, String lessonName, String topics, String link, Course course) {
		super();
		this.id = id;
		this.lessonName = lessonName;
		this.topics = topics;
		this.link = link;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", lessonName=" + lessonName + ", topics=" + topics + ", link=" + link + ", course="
				+ course + "]";
	}
	
	
}

















