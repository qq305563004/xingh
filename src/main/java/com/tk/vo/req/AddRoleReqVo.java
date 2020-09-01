package com.tk.vo.req;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class AddRoleReqVo {

	/* 角色名称 */
	@NotEmpty()
	private String rolename;

	/* 权限列表 */
	@NotEmpty()
	private List<Integer> permissionList;

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<Integer> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Integer> permissionList) {
		this.permissionList = permissionList;
	}
}
