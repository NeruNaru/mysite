package com.javaex.vo;

public class GuestbookVO {
	//field
	private int no;
	private String userName;
	private String password;
	private String regDate;
	private String content;
	//editor
	public GuestbookVO(int no, String userName, String password, String regDate, String content) {
		super();
		this.no = no;
		this.userName = userName;
		this.password = password;
		this.regDate = regDate;
		this.content = content;
	}
	public GuestbookVO() {
		super();
	}
	//method g/s
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	//method normal
	@Override
	public String toString() {
		return "GuestbookVO [no=" + no + ", userName=" + userName + ", password=" + password + ", regDate=" + regDate
				+ ", content=" + content + "]";
	}
}
