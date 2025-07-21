package com.javaex.service;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.repository.AttachRepository;
import com.javaex.vo.FileVO;

@Service
public class AttachService {
	//field
	private AttachRepository attachrepository;
	//editor
	
	//method g/s
	
	//method normal
	
	//파일업로드
	public String exeUpload(MultipartFile file) {
		System.out.println("AttachService.exeUpload()");
		
		//파일 저장경로
		String saveDir = "C:\\javastudy\\upload\\";
		
		//=오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println("original name: " + orgName);
		//확장자명
		String exName = orgName.substring(orgName.lastIndexOf(".")+1);
		System.out.println("extasion name: " + exName);
		//저장파일명
		String saveName = System.currentTimeMillis()+UUID.randomUUID().toString()+"."+exName;
		System.out.println("save file name: " + saveName);
		//파일경로
		String filePath = saveDir+saveName;
		System.out.println("file path: " + filePath);
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println("file size: " + (fileSize/1024) + "MB");
		//vo에 묶는다 ==> db에 저장
		FileVO filevo = new FileVO(orgName, exName, saveName, filePath, fileSize);
		System.out.println(filevo);
		//실물파일을 하드드라이브에 저장
		try {
			byte[] fileData = file.getBytes();
			
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		return saveName;
	}
}
