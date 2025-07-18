package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.AttatchService;

@Controller
public class AttatchController {
	//field
	@Autowired
	private AttatchService attatchservice;
	//editor
	
	//method g/s
	
	//method normal
	@RequestMapping(value="/attach/upload", method= {RequestMethod.GET, RequestMethod.POST})
	public String fileUpload(@RequestParam(value="file") MultipartFile file) {
		System.out.println("AttatchController.upload()");
		
		attatchservice.exeFileUpload(file);
		
		return "";
	}
	
}
