package com.tk.mapper;

import com.tk.bean.Userrole;
import com.tk.utils.MyMapper;

public interface UserroleMapper extends MyMapper<Userrole> {
	int insertGeneratedKey(Userrole userrole);
	
	void deleteUserRole(Integer userid);
	
	Userrole findByUserId(Integer userid);
	
	Userrole findByRoleId(Integer roleid);
}