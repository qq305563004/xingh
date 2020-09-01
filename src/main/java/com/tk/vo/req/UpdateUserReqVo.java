package com.tk.vo.req;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class UpdateUserReqVo {

	@Min(1)
	private int id;

	@NotEmpty()
	private String mail;

	@NotEmpty()
	private String phone;

	private int roleid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
