package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVO;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/board")
public class BoardController {
	//field
	@Autowired
	private BoardService boardservice;
	//editor
		
	//method g/s
		
	//method normal
	
	//-게시판 전체 리스트 (페이징 기능 추가)
		@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
		public String list(@RequestParam(value="crtpage", required=false, defaultValue="1") int crtPage, Model model) {
			System.out.println("BoardController.list()");
			
			Map<String, Object> pMap = boardservice.exeList(crtPage);
			System.out.println(pMap);
			
			model.addAttribute("pMap", pMap);

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
	@RequestMapping(value="/edit", method = {RequestMethod.GET, RequestMethod.POST})
	public String edit(@ModelAttribute BoardVO editorvo) {
		System.out.println("BoardController.edit()");
		
		System.out.println(editorvo);
		
		boardservice.exeBoardUpdate(editorvo);
		
		return"redirect:/board/list";
	}
	
	//게시판 글 쓰기(writeform)
	@RequestMapping(value="/writeform", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("BoardController.writeForm()");
		
		
		
		return "board/writeform";
	}
	
	//게시판 글 쓰기(write)
	@RequestMapping(value="/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVO boardvo, HttpSession session) {
		System.out.println("BoardController.write()");
		
		int userNo = ((UserVO)session.getAttribute("authuser")).getNo();
		System.out.println(userNo);
		
		boardvo.setNo(userNo);
		System.out.println(boardvo);
		
		boardservice.exeBoardWrite(boardvo);
		
		return "board/list";
	}
	
	//-게시판 전체 리스트3 (페이징 기능 추가, 검색기능 추가)
	@RequestMapping(value="/list3", method = {RequestMethod.GET, RequestMethod.POST})
	public String list3(@RequestParam(value="crtpage", required=false, defaultValue="1") int crtPage, 
						@RequestParam(value="kwd", required=false, defaultValue="") String kwd,
						Model model) {
		System.out.println("BoardController.list3()");
				
		System.out.println(crtPage);
		System.out.println(kwd);
				
				
		Map<String, Object> pMap = boardservice.exeList3(crtPage, kwd);
		System.out.println("pMap" + pMap);
				
				
		model.addAttribute("pMap", pMap);
				
				
		return "board/list3";
	}
}
