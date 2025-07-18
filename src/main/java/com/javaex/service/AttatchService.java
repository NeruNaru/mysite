package com.javaex.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.repository.AttatchRepository;
import com.javaex.vo.FileVO;

@Service
public class AttatchService {
	//field
	@Autowired
	private AttatchRepository attatchrepository;
	//editor
	
	//method g/s
	
	//method normal
	public String exeFileUpload(MultipartFile file) {
		System.out.println("AttatchService.exeUpload()");
		
		//=file save directory
		String saveDir = "C:\\javaStudy\\upload";
		//=original file name
		String orgName = file.getOriginalFilename();
		//=extension
		String exName = orgName.substring(orgName.lastIndexOf(".")+1);
		//=save file name
		System.out.println(System.currentTimeMillis());
		System.out.println(UUID.randomUUID().toString());
		String saveName = System.currentTimeMillis()+UUID.randomUUID().toString()+"."+exName;
		System.out.println(saveName);
		//=file path
		String filePath = "저장경로= " + saveDir+saveName;
		//=file size
		long fileSize = file.getSize();
		System.out.println(fileSize/1024 + "MB(메가바이트)");
		// vo로 묶기
		FileVO filevo = new FileVO(orgName, exName, saveName, filePath, fileSize);
		System.out.println(filevo);
		return "";
	}
}
