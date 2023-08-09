package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.LessonRepository;

@Service
public class TrainerServiceImp implements TrainerService {

	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	LessonRepository lessonRepo;
	
	@Override
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public String saveCourse(Course course) {
		courseRepo.save(course);
		return "Course Saved Successfully..!";
	}

	@Override
	public String addLesson(Lesson lesson) {
		lessonRepo.save(lesson);
		return "lesson added Successfully";
	}

	@Override
	public Course getCourse(int courseId) {
		return courseRepo.findById(courseId).get();
	}

	@Override
	public List<Course> courseList() {
		return courseRepo.findAll();
	}

}
