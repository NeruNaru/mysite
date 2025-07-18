package com.javaex.vo;

public class UserVO {
	//field
	private int no;
	private String id;
	private String password;
	private String name;
	private String gender;
	//editor
	public UserVO() {
		super();
	}
	
	public UserVO(int no, String id, String password, String name, String gender) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
	}
	//method g/s

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	//method normal

	@Override
	public String toString() {
		return "MysiteVO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ "]";
	}
}
