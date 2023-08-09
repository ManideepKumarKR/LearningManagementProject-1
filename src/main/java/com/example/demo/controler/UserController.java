package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/nav")
public class UserController {
	
	UserService us;
	
	public UserController(UserService us) {
		this.us=us;
	}

	@GetMapping("/register")
	public String register() {
		return "registration";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/addUser")
	public  String addNewUser(
			@RequestParam("name")String name,
			@RequestParam("email")String email,
			@RequestParam("password")String password,
			@RequestParam("role")String role) {
		boolean emailExists=us.checkEmail(email);
		if(emailExists==false) {
		Users user=new Users();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		us.addUser(user);
		
		System.out.println("user registered successfully!");
		return "redirect:/nav/login" ;
		}
		
		if(emailExists==true) {
			System.out.println("Allready user exist by Email Please login");
			return "redirect:/nav/login";
		}
		
		else {
			return "redirect:/nav/registrationFail" ;
		}		
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email")String email,
	    @RequestParam("password")String password,
	   HttpSession session) {
	if(us.checkEmail(email)) {
	boolean val=us.validate(email, password);
	//if user is valid
	if(val==true) {
	Users user = us.getUser(email); // Assuming you have a method to get the User object
	session.setAttribute("loggedInUser", user); // Saving the User object in session
	if(us.getUserRole(email).equals("trainer")) {
	return "trainerHome";
	}

	else {
	 return "studentHome";
	 }
	}

	else {
	  System.out.println("incorrect credentials, try again!");
	  return "loginFail";
	 }
	}
	 else {
	   return "loginFail";
	  }
	}
	
	@GetMapping("/createCourse")
	public String createCourse()
	{
	return "createCourse";
	}
	
	
	@GetMapping("/addLesson")
	public String addLesson() {
	return "addLesson";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}










