package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVO;


@Controller
public class BoardController {
	//field
	@Autowired
	private BoardService boardservice;
	//editor
		
	//method g/s
		
	//method normal
	@RequestMapping(value="/board/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(@ModelAttribute BoardVO boardvo ,Model model) {
		System.out.println("BoardController.list()");
		
		List<BoardVO> boardList = boardservice.exeGetBoardList();
		
		model.addAttribute("bList", boardList);
		System.out.println(boardList);
		
		return "board/list";
	}
}
