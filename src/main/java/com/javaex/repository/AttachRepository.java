package com.javaex.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class AttachRepository {
	//field
	@Autowired
	private SqlSession sqlsession;
	//editor
	
	//method g/s
	
	//method normal
	public String fileUpload(MultipartFile file) {
		System.out.println("AttachRepository.fileUpload()");
		
		System.out.println(file);
		
		return "";
	}
}
