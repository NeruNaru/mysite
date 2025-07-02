package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//# 게시판 전체 리스트2(페이징 기능 추가) service
		public Map<String, Object> exeList(int crtPage){
			System.out.println("BoardService.exeList()");
			
			//한 페이지의 출력 갯수
			int listCnt = 10;
			
			//시작 번호
			/*
			 * 1페이지 => (0,10)
			 * 2페이지 => (10,10)
			 * 3페이지 => (20,10)
			 * ...
			 */
			int startRowNo = (crtPage - 1)*listCnt;
			
			//두 개의 데이터를 묶는다	--> Map 사용
			Map<String, Integer> limitMap = new HashMap<String, Integer>();
			limitMap.put("startRowNo", startRowNo);
			limitMap.put("listCnt", listCnt);
			
			//repository로 전송
			List<BoardVO> boardList = boardrepository.boardSelectList(limitMap);
			
			//		페이지 버튼(하단 버튼)		//
			
			// 끝 버튼 번호 endPageBtnNo
			int pageBtnCount = 5;
			
			int endPageBtnNo = (int)(Math.ceil(crtPage/(double)pageBtnCount))*pageBtnCount;
			System.out.println(endPageBtnNo);
			
			// 시작 버튼 번호 startPageBtnNo
			int startPageBtnNo = (endPageBtnNo - pageBtnCount)+1;
			
			System.out.println(startPageBtnNo + "~" + endPageBtnNo);
			
			//한 페이지당 글 갯수 (10)+5	 <  실제 전체 글 갯수 = 51	==> true
			
			//한 페이지당 글 갯수 (10)+5	 >  실제 전체 글 갯수 = 49	==> false
			//전체 글 갯수
			int totalCount = boardrepository.selectTotalCount();
			
			boolean next = false;
			if(listCnt*endPageBtnNo < totalCount) {
				next = true;
			} else {
				endPageBtnNo = (int)(Math.ceil(totalCount/(double)listCnt));
			}
			
			// 이전 화살표 유무 prev
			
			boolean prev = false;
			if(startPageBtnNo != 1) {
				prev = true;
			}
			
			// 모두 묶어서 컨드롤러에 뿌려준다
			
			Map<String, Object> pMap = new HashMap<String, Object>();
			pMap.put("boardList", boardList);	//리스트
			pMap.put("prev", prev);		//이전버튼 유무
			pMap.put("next", next);		//다음버튼 유무
			pMap.put("startPageBtnNo", startPageBtnNo);		//시작 버튼 번호
			pMap.put("endPageBtnNo", endPageBtnNo);			//마지막 버튼 번호
			
			return pMap;
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
	
	//# 게시글 수정
	public int exeBoardUpdate(BoardVO boardvo) {
		System.out.println("BoardService.exeBoardUpdate()");
		
		int count = boardrepository.boardUpdate(boardvo);
		
		return count;
	}
	
	//# 게시글 작성
	public int exeBoardWrite(BoardVO boardvo) {
		System.out.println("BoardService.exeBoardWrite()");
		
		int count = boardrepository.boardInsert(boardvo);
		
		return count;
	}
	
	//# 게시판 전체 리스트3(페이징 기능 추가, 검색기능 추가) service
			public Map<String, Object> exeList3(int crtPage, String kwd){
				System.out.println("BoardService.exeList3()");
				
				System.out.println("crtPage=>" + crtPage + ", kwd=>" + kwd);
				
				//한 페이지의 출력 갯수
				int listCnt = 10;
				
				//시작 번호
				/*
				 * 1페이지 => (0,10)
				 * 2페이지 => (10,10)
				 * 3페이지 => (20,10)
				 * ...
				 */
				int startRowNo = (crtPage - 1)*listCnt;
				
				//두 개의 데이터를 묶는다	--> Map 사용
				Map<String, Object> limitMap = new HashMap<String, Object>();
				limitMap.put("startRowNo", startRowNo);
				limitMap.put("listCnt", listCnt);
				limitMap.put("kwd", kwd);
				
				//repository로 전송
				List<BoardVO> boardList = boardrepository.boardSelectList3(limitMap);
				
				//		페이지 버튼(하단 버튼)		//
				
				// 끝 버튼 번호 endPageBtnNo
				int pageBtnCount = 5;
				
				int endPageBtnNo = (int)(Math.ceil(crtPage/(double)pageBtnCount))*pageBtnCount;
				System.out.println(endPageBtnNo);
				
				// 시작 버튼 번호 startPageBtnNo
				int startPageBtnNo = (endPageBtnNo - pageBtnCount)+1;
				
				System.out.println(startPageBtnNo + "~" + endPageBtnNo);
				
				//한 페이지당 글 갯수 (10)+5	 <  실제 전체 글 갯수 = 51	==> true
				
				//한 페이지당 글 갯수 (10)+5	 >  실제 전체 글 갯수 = 49	==> false
				//전체 글 갯수
				int totalCount = boardrepository.selectTotalCountByKwd(kwd);
				
				boolean next = false;
				if(listCnt*endPageBtnNo < totalCount) {
					next = true;
				} else {
					endPageBtnNo = (int)(Math.ceil(totalCount/(double)listCnt));
				}
				
				// 이전 화살표 유무 prev
				
				boolean prev = false;
				if(startPageBtnNo != 1) {
					prev = true;
				}
				
				// 모두 묶어서 컨드롤러에 뿌려준다
				
				Map<String, Object> pMap = new HashMap<String, Object>();
				pMap.put("boardList", boardList);	//리스트
				pMap.put("prev", prev);		//이전버튼 유무
				pMap.put("next", next);		//다음버튼 유무
				pMap.put("startPageBtnNo", startPageBtnNo);		//시작 버튼 번호
				pMap.put("endPageBtnNo", endPageBtnNo);			//마지막 버튼 번호
				
				return pMap;
			}
}
