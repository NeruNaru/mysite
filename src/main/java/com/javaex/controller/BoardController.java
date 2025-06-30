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
@RequestMapping(value="/board")
public class BoardController {
	//field
	@Autowired
	private BoardService boardservice;
	//editor
		
	//method g/s
		
	//method normal
	
	// 게시판 전체 리스트 출력(list)
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(@ModelAttribute BoardVO boardvo ,Model model) {
		System.out.println("BoardController.list()");
		
		List<BoardVO> boardList = boardservice.exeGetBoardList();
		
		model.addAttribute("bList", boardList);
		System.out.println(boardList);
		
		return "board/list";
	}
	
	// 게시판 글 보기(read)
	@RequestMapping(value="/read", method = {RequestMethod.GET, RequestMethod.POST})
	public String read(@ModelAttribute BoardVO boardvo, Model model) {
		System.out.println("BoardController.read()");
		
		//boardvo 에서 no값을 가져오기
		System.out.println(boardvo);
		int no = boardvo.getNo();
		
		System.out.println(no);
		
		//no를 service로 넘겨서 정보를 readervo 형태로 받기
		BoardVO readervo = boardservice.exeBoardSelectOne(no);
		System.out.println(readervo);
		
		//readervo 모델에 담는다
		model.addAttribute("readervo", readervo);
		
		return "board/read";
	}
	
	// 게시판 수정폼(edit form)
	@RequestMapping(value="/editform", method = {RequestMethod.GET, RequestMethod.POST})
	public String editForm(@ModelAttribute BoardVO boardvo, Model model) {
		System.out.println("BoardController.editForm()");
		
		//boardvo에서 no값을 가져오기
		System.out.println(boardvo);
		int no = boardvo.getNo();
		
		//no를 service로 넘겨서 정보를 editervo 형태로 받기
		BoardVO editorvo = boardservice.exeBoardSelectOne2(no);
		System.out.println(editorvo);
		
		//editorvo 모델에 담는다
		model.addAttribute("editorvo", editorvo);
		
		return "board/editform";
	}
	
	//게시판 글 수정(edit)
	public String edit(@ModelAttribute BoardVO editorvo) {
		System.out.println("BoardController.edit()");
		
		System.out.println(editorvo);
		
		return"";
	}
}
