package com.javaex.vo;

public class FileVO {
	//field
	private String orgName;
	private String exName;
	private String saveName;
	private String filedPath;
	private long fileSize;
	//editor
	public FileVO() {
		super();
	}
	public FileVO(String orgName, String exName, String saveName, String filedPath, long fileSize) {
		super();
		this.orgName = orgName;
		this.exName = exName;
		this.saveName = saveName;
		this.filedPath = filedPath;
		this.fileSize = fileSize;
	}
	//method g/s
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getExName() {
		return exName;
	}
	public void setExName(String exName) {
		this.exName = exName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public String getFiledPath() {
		return filedPath;
	}
	public void setFiledPath(String filedPath) {
		this.filedPath = filedPath;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	//method normal
	@Override
	public String toString() {
		return "FileVO [orgName=" + orgName + ", exName=" + exName + ", saveName=" + saveName + ", filedPath="
				+ filedPath + ", fileSize=" + fileSize + "]";
	}
}
