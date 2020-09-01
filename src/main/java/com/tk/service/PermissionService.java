package com.tk.service;

import java.util.List;

import com.tk.vo.res.PermissionResVo;

public interface PermissionService {
	List<PermissionResVo> getAllPermission();
	
	List<PermissionResVo> getPermissionByUser(String userName);
}
