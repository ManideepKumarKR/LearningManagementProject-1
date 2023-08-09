package com.example.demo.controler;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;
import com.example.demo.services.TrainerService;

@Controller
public class TrainerController {
	
	TrainerService tService;

	public TrainerController(TrainerService tService) {
    this.tService=tService;
	}
	
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam("courseId")int courseId,
			@RequestParam("courseName")String courseName,
			@RequestParam("coursePrice")int coursePrice) 
	{
		Course course=new Course();
		course.setId(courseId);
		course.setCourseName(courseName);
		course.setCoursePrice(coursePrice);
		
	     Course c=tService.addCourse(course);
	     if(c!=null)
	     {
	     return "/trainerHome";
	     }
	     else
	     {
	    	 return "/createCourseFail";
	     }
	}
	
	@PostMapping("/lesson")
	public String lesson(@RequestParam("courseId")int courseId,
			@RequestParam("lessonId")int lessonId,
			@RequestParam("lessonName")String lessonName,
			@RequestParam("topics")String topics,
			@RequestParam("link")String link) {
		
		Course course=tService.getCourse(courseId);
		
		Lesson lesson=new Lesson(lessonId,lessonName,topics,link,course);
		tService.addLesson(lesson);
		
		course.getLesson().add(lesson);
		
		tService.saveCourse(course);
		
		return "/trainerHome";
	}	
	
	@GetMapping("/showCourses")
	public String showCourses(Model model) {
		List<Course> courseList=tService.courseList();
		model.addAttribute("courseList",courseList);
		System.out.println(courseList);
		return "courses";
	}
	
	
}
