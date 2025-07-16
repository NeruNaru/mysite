package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVO;

@Controller
@RequestMapping(value="/guestbook")
public class GuestbookController {
	//field
	@Autowired
	private GuestbookService guestbookservice;
	//editor
	
	//method g/s
	
	//method normal
	
	//-일반방명록 리스트
	@RequestMapping(value="/addlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("GuestbookController.addList()");
		
		List<GuestbookVO> guestList = guestbookservice.exeAddList();
		
		model.addAttribute("gList", guestList);
		
		return "guestbook/addlist";	
	}
	
	//-방명록 등록
	@RequestMapping(value="/insert", method = {RequestMethod.GET, RequestMethod.POST})
	public String insertGuestbook(@ModelAttribute GuestbookVO guestbookvo) {
		System.out.println("GuestbookController.insertGuestbook()");
		
		guestbookservice.exeInsertGuestbook(guestbookvo);
		
		return "redirect:/guestbook/addlist";
	}
	
	//- 삭제폼
	@RequestMapping(value="/removeform", method = {RequestMethod.GET, RequestMethod.POST})
	public String removeform() {
		System.out.println("GuestbookController.removeForm()");
		
		return "guestbook/removeform";
	}
	
	@RequestMapping(value="/remove", method = {RequestMethod.GET, RequestMethod.POST})
	public String remove(@ModelAttribute GuestbookVO guestbookvo) {
		System.out.println("GuestbookController.remove()");
		
		guestbookservice.exeRemoveGuestbook(guestbookvo);
		
		return "redirect:/guestbook/addlist";
	}
	
}
