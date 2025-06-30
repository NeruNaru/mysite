package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;

@Repository
public class BoardRepository {
	//field
	@Autowired
	private SqlSession sqlsession;
	//editor
		
	//method g/s
		
	//method normal
	public List<BoardVO> boardSelectList(){
		System.out.println("BoardRepository.boardSelectAll()");
		
		List<BoardVO> boardList = sqlsession.selectList("board.selectList");
		System.out.println(boardList);
		
		return boardList;
	}
}
