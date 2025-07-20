package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVO;

@Repository
public class GuestbookRepository {
	//field
	@Autowired
	private SqlSession sqlsession;
	//editor
	
	//method g/s
	
	//method normal
	
	//-방명록 리스트 보기 repository
	public List<GuestbookVO> guestbookAddList(){
		System.out.println("GuestbookRepository.guestbookAddList()");
		
		List<GuestbookVO> guestbookList = sqlsession.selectList("guestbook.selectList");
		
		return guestbookList;
	}
	
	//-방명록 추가 repository
	public int guestbookInsert(GuestbookVO guestbookvo) {
		System.out.println("GuestbookRepository.guestbookInsert()");
		
		System.out.println(guestbookvo);
		
		int count = sqlsession.insert("guestbook.insertGuestbook", guestbookvo);
		
		return count;
	}
	
	//-방명록 삭제하기 repository
	public int guestbookRemove(GuestbookVO guestbookvo) {
		System.out.println("GuestbookRepository.guestbookRemove()");
		
		int count = sqlsession.delete("guestbook.removeGuestbook", guestbookvo);
		
		return count;
	}
}
