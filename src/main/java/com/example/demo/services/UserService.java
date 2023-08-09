package com.example.demo.services;


import com.example.demo.entity.Users;


public interface UserService {
	//adds new user to database
String addUser(Users user);
   // checkemail is already present in database or not
boolean checkEmail(String email);
   //validate users's credentials
boolean validate (String email,String password);
//      // getting user
Users getUser(String email);
//   //getting the User Role
String getUserRole(String email);

String updateuser(Users user);


/* boolean checkEmail(String email);

//validates user's credentials

boolean validate(String email, String password);

Users getUser(String email);

String getUserRole(String email);

String addUser(Users user);

String updateUser(Users user);*/


}
