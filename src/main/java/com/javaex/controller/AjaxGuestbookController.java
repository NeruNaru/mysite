package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AjaxGuestbookController {
	//field
	
	//editor
	
	//method g/s
	
	//method normal
	@RequestMapping(value = "/ajaxguestbook", method = { RequestMethod.GET, RequestMethod.POST })
	// ajax용 메인화면
	public String ajaxindex() {
		System.out.println("GuestbookController.ajaxindex()");

		return "ajaxguestbook/index";
	}
}
