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
	
	//# 전체 리스트 조회 repository
	public List<BoardVO> boardSelectList(){
		System.out.println("BoardRepository.boardSelectAll()");
		
		List<BoardVO> boardList = sqlsession.selectList("board.selectList");
		System.out.println(boardList);
		
		return boardList;
	}
	
	//# 한가지 리스트 조회 repository
	public BoardVO boardSelectOne(int no) {
		System.out.println("BoardRepository.boardSelectOne()");
		System.out.println(no);
		
		BoardVO readervo = sqlsession.selectOne("board.selectOne", no);
		
		return readervo;
	}
	
	//# 한가지 리스트 조회2 repository
	public BoardVO boardSelectOne2(int no) {
		System.out.println("BoardRepository.boardSelectOne()");
		System.out.println(no);
		
		BoardVO editorvo = sqlsession.selectOne("board.selectOne", no);
		
		return editorvo;
	}
	
	//# 조회수 증가 repository
	public int updateHit(int no) {
		System.out.println("BoardRepository.updateHit()");
		System.out.println(no);
		
		int count = sqlsession.update("board.updateHit", no);
		
		return count;
	}
	
	public int boardUpdate() {
		System.out.println("BoardRepository.boardUpdate()");
		
		return 0;
	}
}
