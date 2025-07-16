package com.javaex.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVO;

@Repository
public class UserRepository {
	//field
	@Autowired
	private SqlSession sqlsession;
	//editor
		
	//method g/s
		
	//method normal
	
	//user join save(유저 저장(회원가입))
	public int userInsert(UserVO uservo) {
		System.out.println("UserRepository.userInsert()");
		
		System.out.println(uservo);
		int count = sqlsession.insert("user.insert",uservo);
		System.out.println("count=" + count);
		
		System.out.println(uservo);
		return count;
	}
	
	//user login (유저 로그인)
	public UserVO userSelectOneIdPw(UserVO uservo) {
		System.out.println("UserRepository.userSelectOneIdPw()");
		
		System.out.println(uservo);
		UserVO authuser = sqlsession.selectOne("user.selectOneIdPw", uservo);
		
		System.out.println(authuser);
		
		return authuser;
	}
	
	//userselectno
	public UserVO userSelectNo(int no) {
		System.out.println("UserRepository.userSelectNo()");
		System.out.println(no);
		
		UserVO uservo = sqlsession.selectOne("user.selectNo",no);
		System.out.println(uservo);
		
		return uservo;
	}
	
	//userupdate (유저 정보수정)
	public int userUpdate(UserVO uservo) {
		System.out.println("UserRepository.userUpdate()");
		
		System.out.println(uservo);
		
		int count = sqlsession.update("user.update", uservo);
		
		return 0;
	}
	
	//아이디 사용 유무 체크
	public UserVO userSelectById(String id) {
		System.out.println("UserRepository.userSelectById()");
		System.out.println(id);
		
		UserVO uservo = sqlsession.selectOne("user.selectOneById", id);
		
		return uservo;
	}
}
