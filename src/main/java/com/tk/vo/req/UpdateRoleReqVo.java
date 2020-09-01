package com.tk.vo.req;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class UpdateRoleReqVo {

	/* 角色ID */
	@Min(1)
	private Integer roleid;

	/* 权限列表 */
	@NotEmpty()
	private List<Integer> permissionList;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public List<Integer> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Integer> permissionList) {
		this.permissionList = permissionList;
	}
}
