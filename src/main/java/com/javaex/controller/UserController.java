package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String editForm(HttpSession session, Model model) {
		System.out.println("UserController.editForm()");
		
		//세션에서 no값을 가져오기 (현재 접속한 사용자의 no값)
		UserVO authuser = (UserVO)session.getAttribute("authuser");
		int no = authuser.getNo();
		
		//no를 UserService로 넘겨서 정보를 uservo형태로 받는다
		UserVO uservo = userservice.exeEditForm(no);
		System.out.println(uservo);
		
		//uservo모델에 담는다 ==> D.S야 request의 attribute에 담아라
		model.addAttribute("uservo", uservo);
		
		return "user/editform";
	} //edit form
	
	//edit (회원정보 수정)
	@RequestMapping(value = "/user/edit", method= {RequestMethod.GET, RequestMethod.POST})
	public String edit(@ModelAttribute UserVO uservo, HttpSession session) {
		System.out.println("UserController.edit()");
		System.out.println(uservo);
		
		//세션에서 no값을 꺼내오기
		UserVO authuser = (UserVO)session.getAttribute("authuser");
		int no = authuser.getNo();
		System.out.println(no);
		
		//D.S.에서 uservo에 세션에서 꺼낸 no를 추가한다
		uservo.setNo(no);
		System.out.println(uservo);
		
		//서비스에 uservo 전달
		userservice.exeUpdate(uservo);
		
		//헤더의 이름 변경 ==> 세션의 이름 변경
		// 위에서 가져온 authuser로 이름을 변경한다
		authuser.setName(uservo.getName());
		
		return "redirect:/";
	}
	
	//-logout (로그아웃)
	@RequestMapping(value = "/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		
		//세션에 확인용 값을 지운다
		session.removeAttribute("authuser");
		session.invalidate();
		
		return "main/index";
	}
	
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value="/user/idcheck", method = {RequestMethod.GET, RequestMethod.POST})
	public String idCheck(@RequestParam(value="id") String id, Model model) {
		System.out.println("UserController.idCheck()");
		
		System.out.println(id);
		
		boolean isUse = userservice.exeIdCheck(id);
		System.out.println(isUse);
		
		//model.addAttribute("isUse", isUse);		//jsp에 전달하는 코드
		
		String result = "{\"isUse\":"+isUse+"}";
		System.out.println(result);
		
		return result;
	}
	
}
