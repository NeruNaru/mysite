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
	public List<BoardVO> exeGetBoardList() {
		System.out.println("BoardService.exeBoardList()");
		
		List<BoardVO> boardList = boardrepository.boardSelectList();
		
		return boardList;
	}
}
