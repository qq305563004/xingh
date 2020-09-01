package com.tk.service;

import java.util.List;
import java.util.Map;

import com.tk.vo.req.AddRoleReqVo;
import com.tk.vo.req.RoleReqPageVo;
import com.tk.vo.req.UpdateRoleReqVo;
import com.tk.vo.res.PermissionResVo;
import com.tk.vo.res.RoleResVo;

/**
 * 角色管理
 * @author xingh
 *
 */
public interface RoleService {
	
	void addRole(AddRoleReqVo reqVo,int roleType,String userName);
	
	void updateRole(UpdateRoleReqVo reqVo);
	
	void deleteRole(int id);
	
	Map<String, Object> roleList(RoleReqPageVo reqVo);
	
	List<PermissionResVo> getRole(int roleId, String userName);
	
	List<RoleResVo> roleList();
}
