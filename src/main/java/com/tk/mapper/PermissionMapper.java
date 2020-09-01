package com.tk.mapper;

import java.util.List;

import com.tk.bean.Permission;
import com.tk.bean.Rolepermission;
import com.tk.utils.MyMapper;

public interface PermissionMapper extends MyMapper<Permission> {
	List<Permission> findPermissionByName(String name);
	
	List<Permission> findByStatusAndType(Integer status,Integer type);
	
	List<Rolepermission> findByPermissionid(Integer roleid);
	
	List<Permission> findPermissionByRoleId(Integer roleid);
}