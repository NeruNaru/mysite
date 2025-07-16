package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.UserRepository;
import com.javaex.vo.UserVO;

@Service
public class UserService {
	//field
	@Autowired
	private UserRepository userrepository;
	//editor
	
	//method g/s
	
	//method normal
	
	//-user join
	public int exeJoin(UserVO uservo) {
		System.out.println("UserService.exeJoin()");
		
		userrepository.userInsert(uservo);
		
		return 0;
	}
	
	//-user login
	public UserVO exeLogin(UserVO uservo) {
		System.out.println("UserService.exeLogin()");
		
		UserVO authuser = userrepository.userSelectOneIdPw(uservo);
		
		return authuser;
	}
	
	//-userEditForm
	public UserVO exeEditForm(int no) {
		System.out.println("UserService.exeEditForm()");
		System.out.println(no);
		
		UserVO uservo = userrepository.userSelectNo(no);
		
		return uservo;
	}
	
	//-user edit
	public int exeUpdate(UserVO uservo) {
		System.out.println("UserService.exeUpdate()");
		
		int count = userrepository.userUpdate(uservo);
		
		return 0;
	}
	
	//--아이디 사용 유무체크
	public boolean exeIdCheck(String id) {
		System.out.println("UserService.exeIdCheck()");
		System.out.println(id);
		
		UserVO uservo = userrepository.userSelectById(id);
		
		if(uservo == null) {
			return true;
		} else {
			return false;
		}
	}
}
