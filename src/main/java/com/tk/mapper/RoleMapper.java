package com.tk.mapper;

import java.util.List;

import com.tk.bean.Role;
import com.tk.utils.MyMapper;
import com.tk.vo.res.RoleResPageVo;
import com.tk.vo.res.RoleResVo;

public interface RoleMapper extends MyMapper<Role> {
	Role findByRoleName(String rolename);
	
	List<RoleResPageVo> listPagingInfo();
	
	List<RoleResVo> roleList();
}