package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.GuestbookRepository;
import com.javaex.vo.GuestbookVO;

@Service
public class GuestbookService {
	//field
	@Autowired
	private GuestbookRepository guestbookrepository;
	//editor
	
	//method g/s
	
	//method normal
	
	//-방명록 리스트 보기 service
	public List<GuestbookVO> exeAddList() {
		System.out.println("GuestbookService.exeAddList()");
		
		List<GuestbookVO> guestbookList = guestbookrepository.guestbookAddList();
		
		return guestbookList;
	}
	
	//-방명록 등록하기 service
	public int exeInsertGuestbook(GuestbookVO guestbookvo) {
		System.out.println("GuestbookService.exeInsertGuestbook()");
		
		int count = guestbookrepository.guestbookInsert(guestbookvo);
		
		return count;
	}
	
	//-방명록 삭제하기 service
	public int exeRemoveGuestbook(GuestbookVO guestbookvo) {
		System.out.println("GuestbookService.exeRemoveGuestbook()");
		
		System.out.println(guestbookvo);
		
		int count = guestbookrepository.guestbookRemove(guestbookvo);
		
		return count;
	}
}
