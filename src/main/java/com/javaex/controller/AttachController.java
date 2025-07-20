package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.AttachService;


@Controller
public class AttachController {
	//field
	@Autowired
	private AttachService attachservice;
	//editor
	
	//method g/s
	
	//method normal
	
	//파일 업로드 폼
	@RequestMapping(value="/attach/uploadform", method= {RequestMethod.GET, RequestMethod.POST})
	public String uploadform() {
		System.out.println("AttachController.uploadform()");
		
		return "attach/uploadform";
	}
	
	@RequestMapping(value="/attach/upload", method= {RequestMethod.GET, RequestMethod.POST})
	//파일 업로드(파일을 받아서 저장)
	public String upload(@RequestParam(value="file") MultipartFile file) {
		System.out.println("AttachController.upload()");
		
		System.out.println(file);
		attachservice.exeUpload(file);
		
		return "";
	}
	
	//업로드 결과
	@RequestMapping(value="/attach/uploadresult", method= {RequestMethod.GET, RequestMethod.POST})
	public String uploadresult() {
		System.out.println("AttachController.uploadresult()");
		
		return "attach/uploadresult";
	}
}
