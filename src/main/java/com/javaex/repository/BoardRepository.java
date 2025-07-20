package com.javaex.repository;

import java.util.List;
import java.util.Map;

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
	
	//# 게시판 전체 리스트 가져오기(페이징 기능 추가) repository
		public List<BoardVO> boardSelectList(Map<String, Integer> limitMap) {
			System.out.println("BoardRepository.boardSelectList()");
			System.out.println(limitMap);
			
			List<BoardVO> boardList = sqlsession.selectList("board.selectList", limitMap);
			
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
	
	//# 전체 글 갯수 count repository
	public int selectTotalCount() {
		System.out.println("BoardRepository.selectTotalCount()");
		
		int totalCount = sqlsession.selectOne("board.selectTotalCount");
		System.out.println(totalCount);
		
		return totalCount;
	}
	
	//# 게시글 수정 edit repository
	public int boardUpdate(BoardVO boardvo) {
		System.out.println("BoardRepository.boardUpdate()");
		
		int count = sqlsession.update("board.updateBoard", boardvo);
		
		return count;
	}
	
	//# 게시글 작성
	public int boardInsert(BoardVO boardvo) {
		System.out.println("BoardRepository.boardInsert()");
		
		int count = sqlsession.insert("board.insertBoard", boardvo);
		
		return 0;
	}
	
	//# 게시판 전체 리스트 가져오기(페이징 기능 추가, 검색기능 추가) repository
	public List<BoardVO> boardSelectList3(Map<String, Object> limitMap) {
		System.out.println("BoardRepository.boardSelectList3()");
		System.out.println(limitMap);
				
		List<BoardVO> boardList = sqlsession.selectList("board.selectList3", limitMap);
				
		return boardList;
	}
	
	//# 전체 글 갯수 + 키워드 count repository
	public int selectTotalCountByKwd(String kwd) {
		System.out.println("BoardRepository.selectTotalCountByKwd()");
		
		int totalCount = sqlsession.selectOne("board.selectTotalCountByKwd", kwd);
		
		System.out.println("totalCount = " + totalCount);
		
		return totalCount;
	}
}
