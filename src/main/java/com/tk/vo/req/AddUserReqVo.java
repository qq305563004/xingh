package com.tk.vo.req;

import javax.validation.constraints.NotEmpty;

public class AddUserReqVo {
	
	@NotEmpty()
	private String name;

	@NotEmpty()
	private String password;

	@NotEmpty()
	private String mail;

	@NotEmpty()
	private String phone;

	private int roleid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

}
