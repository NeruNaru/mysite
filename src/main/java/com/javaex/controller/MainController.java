package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

	//field
	
	//editor
	
	//method g/s
	
	//method normal
	
	//-사이트 시작 페이지
	@RequestMapping(value="/", method= {RequestMethod.GET, RequestMethod.POST})
	public String index() {
		System.out.println("MaintController.index()");
		
		return "main/index";
	}
	
	@RequestMapping(value="/{id}", method= {RequestMethod.GET, RequestMethod.POST})
	public String aaa() {
		System.out.println("MaintController.index()");
		
		return "main/index";
	}

}
