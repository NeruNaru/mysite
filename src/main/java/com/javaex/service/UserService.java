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
	
	//-user edit
	public int exeEdit(UserVO uservo) {
		System.out.println("UserService.exeEdit()");
		
		userrepository.userEditAccount(uservo);
		
		
		return 0;
	}
}
