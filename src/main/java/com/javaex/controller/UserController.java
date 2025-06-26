package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	// field

	// editor

	// method g/s

	// method normal
	//joinform
	@RequestMapping(value = "/user/joinform", method = {RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		System.out.println("UserController.joinForm()");

		return "user/joinform";
	} //jointform end
	
	//loginform
	@RequestMapping(value = "/user/loginform", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "user/loginform";
	} //loginform end
	
	//loginok
	@RequestMapping(value = "/user/loginok", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginOk() {
		System.out.println("UserController/loginOk()");
		
		return "";
	} //loginok end
	
	//editform
	@RequestMapping(value = "/user/editform", method= {RequestMethod.GET, RequestMethod.POST})
	public String editForm() {
		System.out.println("UserController.editForm()");
		
		return "user/editform";
	} //editform
	
	
	
}
