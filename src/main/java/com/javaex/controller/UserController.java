package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	// field
	@Autowired
	private UserService userservice;
	// editor

	// method g/s

	// method normal
	//join form(회원가입 폼)
	@RequestMapping(value = "/user/joinform", method = {RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		System.out.println("UserController.joinForm()");

		return "user/joinform";
	} //joint form end
	
	//join (회원가입)
	@RequestMapping(value= "/user/join", method = RequestMethod.POST)
	public String join(@ModelAttribute UserVO uservo) {
		System.out.println("UserController.join()");
		
		try {
			userservice.exeJoin(uservo);
			return "user/joinok";
		} catch(DuplicateKeyException e) {
			System.out.println(e);
			System.out.println("잘못된 아이디");
			return"redirect:/user/joinform";
		} catch(Exception e) {
			return "redirect:/user/joinform";
		}
	}
	
	//join okay(가입완료)
	@RequestMapping(value = "/user/loginok", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginOk() {
		System.out.println("UserController/loginOk()");
		
		return "";
	} //join okay end
	
	//login form(로그인 폼)
	@RequestMapping(value = "/user/loginform", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "user/loginform";
	} //login form end
	
	// login (로그인)
	@RequestMapping(value="/user/login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVO uservo, HttpSession session) {
		System.out.println("UserController.login()");
		
		UserVO authuser = userservice.exeLogin(uservo);
		System.out.println(authuser);
		
		//세션에 로그인 확인용 값을 넣어준다 --> 로그인
		session.setAttribute("authuser", authuser);
		
		System.out.println(authuser);
		return "redirect:/";
	}
	
	
	//edit form(회원정보수정 폼)
	@RequestMapping(value = "/user/editform", method= {RequestMethod.GET, RequestMethod.POST})
	public String editForm() {
		System.out.println("UserController.editForm()");
		
		return "user/editform";
	} //edit form
	
	//-logout (로그아웃)
	@RequestMapping(value = "/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		
		//세션에 확인용 값을 지운다
		session.removeAttribute("authuser");
		session.invalidate();
		
		return "main/index";
	}
	
}
