package com.javaex.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class AttachRepository {
	//field
	private SqlSession sqlsession;
	//editor
	
	//method g/s
	
	//method normal
	public String fileUpload() {
		System.out.println("AttachRepository.fileUpload()");
		
		return "";
	}
}
