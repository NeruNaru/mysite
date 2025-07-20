package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVO;

@Controller
public class GuestbookApiController {
	//field
	@Autowired
	private GuestbookService guestbookservice;
	//editor
	
	//method g/s
	
	//method normal
	@ResponseBody
	@RequestMapping(value="/api/guestbook/list", method= {RequestMethod.GET, RequestMethod.POST})
	public List<GuestbookVO> list() {
		System.out.println("GuestbookApiController.list()");
		
		List<GuestbookVO> guestbookList = guestbookservice.exeAddList();
		System.out.println(guestbookList);
		
		return guestbookList;
	}
}
