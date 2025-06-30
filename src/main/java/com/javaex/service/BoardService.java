package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.BoardRepository;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {
	//field
	@Autowired
	private BoardRepository boardrepository;
	//editor
		
	//method g/s
		
	//method normal
	
	//# 전체 리스트 조회 service
	public List<BoardVO> exeGetBoardList() {
		System.out.println("BoardService.exeBoardList()");
		
		List<BoardVO> boardList = boardrepository.boardSelectList();
		
		return boardList;
	}
	
	//# 한가지 조회 service
	public BoardVO exeBoardSelectOne(int no) {
		System.out.println("BoardService.exeBoardSelectOne()");
		System.out.println(no);
		
		//# 조회수 증가
		boardrepository.updateHit(no);
		
		BoardVO readervo = boardrepository.boardSelectOne(no);
		
		return readervo;
	}
	
	//# 한가지 조회2 service
	public BoardVO exeBoardSelectOne2(int no) {
		System.out.println("BoardService.exeBoardSelectOne()");
		System.out.println(no);
		
		BoardVO editorvo = boardrepository.boardSelectOne2(no);
		
		return editorvo;
	}
	
	public int exeBoardUpdate() {
		System.out.println("BoardService.exeBoardUpdate()");
		
		return 0;
	}
}
